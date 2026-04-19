from openai import OpenAI
from dotenv import load_dotenv
load_dotenv()

import json

client = OpenAI()


def summarize_email_to_json(email_content):
    """
    将邮件内容转换为结构化 JSON 摘要
    """
    
    # 2. 定义 Prompt，明确要求的 JSON 结构
    system_prompt = "你是一个专业的邮件分析助手，请输出合法的 JSON 格式数据。"
    user_prompt = f"""
    请分析以下邮件内容，提取关键信息并以 JSON 格式输出。
    
    要求的 JSON 结构如下：
    {{
        "sender": "发件人姓名或称呼",
        "subject_summary": "一句话概括邮件主题",
        "key_points": ["关键点1", "关键点2", ...],
        "action_items": [
            {{ "task": "任务描述", "deadline": "截止时间(如果有)", "owner": "负责人(如果有)" }}
        ],
        "priority": "High/Medium/Low",
        "sentiment": "Positive/Neutral/Negative"
    }}

    邮件内容：
    ---
    {email_content}
    ---
    """

    try:
        # 3. 调用 OpenAI API
        response = client.chat.completions.create(
            model="gpt-5-nano",  # 或 gpt-3.5-turbo-0125 及更新版本
            messages=[
                {"role": "system", "content": system_prompt},
                {"role": "user", "content": user_prompt}
            ],
            # 关键参数：强制输出 JSON 对象
            response_format={ "type": "json_object" }, 
        )

        # 4. 解析返回的 JSON 字符串
        json_response = json.loads(response.choices[0].message.content)
        return json_response

    except Exception as e:
        return {"error": str(e)}

# --- 测试用例 ---
email_text = """
Hi Team,

关于下周二下午2点的 Q3 项目评审会议，请大家务必在周一中午前提交各自模块的进度报告 PPT。
另外，王总提到预算审批已经通过了，我们需要在周五前提交正式的采购清单给财务部。
这次会议非常重要，请大家准时参加。

谢谢！
Alice
"""

# 执行并打印结果
result = summarize_email_to_json(email_text)
print(json.dumps(result, indent=4, ensure_ascii=False))





# # response API 最新的的接口，适用于所有模型，推荐使用
# response = client.responses.create(
#   model="gpt-5-nano",
#   input="Explain how AI works in a few words",
#   store=True,
# )

# print(response.output_text);

# # completion API 适用于部分模型，后续会逐步废弃，不推荐使用
# completion = client.chat.completions.create(
#     model="gpt-5-nano", 
#     messages=[{'role': 'system', 'content': 'You are a helpful assistant.'},
#                 {'role': 'user', 'content': 'Explain how AI works in a few words'}]
#     )

# print(completion.choices[0].message.content)
