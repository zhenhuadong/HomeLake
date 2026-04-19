from openai import OpenAI
from pydantic import BaseModel
from typing import List, Optional
from dotenv import load_dotenv
load_dotenv()

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

# json_schema = EmailSummary.model_json_schema()
# json_schema['additionalProperties'] = False 

# print(json.dumps(json_schema, indent=4, ensure_ascii=False))



json_schema ={
    "$defs": {
        "ActionItem": {
            "properties": {
                "task": {
                    "title": "Task",
                    "type": "string"
                },
                "deadline": {
                    "title": "Deadline",
                    "type": "string"
                },
                "owner": {
                    "title": "Owner",
                    "type": "string"
                }
            },
            "required": [
                "task",
                "deadline",
                "owner"
            ],
            "title": "ActionItem",
            "type": "object",
            "additionalProperties": False
        }
    },
    "properties": {
        "sender": {
            "title": "Sender",
            "type": "string"
        },
        "subject_summary": {
            "title": "Subject Summary",
            "type": "string"
        },
        "key_points": {
            "items": {
                "type": "string"
            },
            "title": "Key Points",
            "type": "array"
        },
        "action_items": {
            "items": {
                "$ref": "#/$defs/ActionItem"
            },
            "title": "Action Items",
            "type": "array"
        },
        "priority": {
            "title": "Priority",
            "type": "string"
        },
        "sentiment": {
            "title": "Sentiment",
            "type": "string"
        }
    },
    "required": [
        "sender",
        "subject_summary",
        "key_points",
        "action_items",
        "priority",
        "sentiment"
    ],
    "type": "object",
    "additionalProperties": False
}

response_format={
    "type": "json_schema",
    "json_schema": {
        "name": "email_summary",
        "strict": True, # 开启严格模式，确保 100% 符合 schema
        "schema": json_schema,
    }
}
    
model = "gpt-5-nano"
system_prompt = "你是一个专业的邮件分析助手，请输出合法的 JSON 格式数据。"

def responses_api_parse(email_content):
    # 调用 OpenAI responses API
    response = client.responses.parse(
        model=model,
        input=[
            {"role": "system", "content": system_prompt},
            {"role": "user", "content": email_content},
        ],
        # two options text or text_format:
        # text_format=EmailSummary,
        text={
            "format": {
                "type": "json_schema",
                "name": "email_summary",
                "strict": True, # 开启严格模式，确保 100% 符合 schema
                "schema": json_schema

            },
        },
    )
    return response.output_text

def responses_api_create(email_content):
    # 调用 OpenAI responses API
    response = client.responses.create(
        model=model,
        input=[
            {"role": "system", "content": system_prompt},
            {"role": "user", "content": email_content},
        ],
        text={
            "format": {
                "type": "json_schema",
                "name": "email_summary",
                "strict": True, # 开启严格模式，确保 100% 符合 schema
                "schema": json_schema

            },
            "verbosity": "low",
        },
    )
    return response.output_text

def completions_api_parse(email_content):
    # 调用 OpenAI completions API
    response = client.chat.completions.parse(
        model=model,
        messages=[
            {"role": "system", "content": system_prompt},
            {"role": "user", "content": email_content},
        ],
        # two options for response_format:
        # response_format=EmailSummary,
        response_format=response_format,
    )
    return response.choices[0].message.content

def completions_api_create(email_content):
    # 调用 OpenAI completions API
    response = client.chat.completions.create(
        model=model,
        messages=[
            {"role": "system", "content": system_prompt},
            {"role": "user", "content": email_content},
        ],
        # two options for response_format:
        # response_format=EmailSummary,
        response_format=response_format,
    )
    return response.choices[0].message.content

def summarize_email_to_json(email_content):
    """ 将邮件内容转换为结构化 JSON 摘要 """    
    try:
        return responses_api_parse(email_content)
        # return responses_api_create(email_content)
        # return completions_api_parse(email_content)
        # return completions_api_create(email_content)
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
