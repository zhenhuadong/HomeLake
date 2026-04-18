from openai import OpenAI
from dotenv import load_dotenv
load_dotenv()

import json
from pydantic import BaseModel, Field
from typing import List, Optional

client = OpenAI()


class ActionItem(BaseModel):
    task: str
    deadline: Optional[str] = None
    owner: Optional[str] = None


class EmailSummary(BaseModel):
    sender: str
    subject_summary: str
    key_points: List[str]
    action_items: List[ActionItem]
    priority: str
    sentiment: str

json_schema = EmailSummary.model_json_schema()
# json_schema['additionalProperties'] = False 

# print(json.dumps(json_schema, indent=4, ensure_ascii=False))

# response_format={
#     "type": "json_schema",
#     "json_schema": {
#         "name": "email_summary",
#         "strict": True, # 开启严格模式，确保 100% 符合 schema
#         "schema": {
#             "type": "object",
#             "properties": {
#                 "sender": {"type": "string"},
#                 "priority": {"type": "string", "enum": ["high", "medium", "low"]},
#                 "key_points": {"type": "array", "items": {"type": "string"}}
#             },
#             "required": ["sender", "priority", "key_points"],
#             "additionalProperties": False # 严格模式下必须设为 False
#         }
#     }
# }

# json_schema ={
#     "$defs": {
#         "ActionItem": {
#             "properties": {
#                 "task": {
#                     "title": "Task",
#                     "type": "string"
#                 },
#                 "deadline": {
#                     "anyOf": [
#                         {
#                             "type": "string"
#                         },
#                         {
#                             "type": "null"
#                         }
#                     ],
#                     "default": null,
#                     "title": "Deadline"
#                 },
#                 "owner": {
#                     "anyOf": [
#                         {
#                             "type": "string"
#                         },
#                         {
#                             "type": "null"
#                         }
#                     ],
#                     "default": null,
#                     "title": "Owner"
#                 }
#             },
#             "required": [
#                 "task"
#             ],
#             "title": "ActionItem",
#             "type": "object"
#         }
#     },
#     "properties": {
#         "sender": {
#             "title": "Sender",
#             "type": "string"
#         },
#         "subject_summary": {
#             "title": "Subject Summary",
#             "type": "string"
#         },
#         "key_points": {
#             "items": {
#                 "type": "string"
#             },
#             "title": "Key Points",
#             "type": "array"
#         },
#         "action_items": {
#             "items": {
#                 "$ref": "#/$defs/ActionItem"
#             },
#             "title": "Action Items",
#             "type": "array"
#         },
#         "priority": {
#             "title": "Priority",
#             "type": "string"
#         },
#         "sentiment": {
#             "title": "Sentiment",
#             "type": "string"
#         }
#     },
#     "required": [
#         "sender",
#         "subject_summary",
#         "key_points",
#         "action_items",
#         "priority",
#         "sentiment"
#     ],
#     "title": "EmailSummary",
#     "type": "object",
#     "additionalProperties": False
# }


def summarize_email_to_json(email_content):
    """
    将邮件内容转换为结构化 JSON 摘要
    """
    
    # 2. 定义 Prompt，明确要求的 JSON 结构
    system_prompt = "你是一个专业的邮件分析助手，请输出合法的 JSON 格式数据。"
    user_prompt = email_content

    try:
        # 3. 调用 OpenAI API
        # response = client.responses.parse(
        #     model="gpt-5-nano",  # 或 gpt-3.5-turbo-0125 及更新版本
        #     input=[
        #         {"role": "system", "content": system_prompt},
        #         {"role": "user", "content": user_prompt},
                
        #     ],
        #     text_format=EmailSummary,
        # )
        # return response.output_text
        response = client.chat.completions.parse(
            model="gpt-5-nano",  # 或 gpt-3.5-turbo-0125 及更新版本
            messages=[
                {"role": "system", "content": system_prompt},
                {"role": "user", "content": user_prompt},
                
            ],
            response_format=EmailSummary,
            # {
            #     "type": "json_schema",
            #     "json_schema": {
            #         "name": "email_summary",
            #         "strict": True, # 开启严格模式，确保 100% 符合 schema
            #         "schema": json_schema
            #     }
            # },
        )
        return response.choices[0].message.content
        

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
# print(json.dumps(result, indent=4, ensure_ascii=False))
print(result)




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
