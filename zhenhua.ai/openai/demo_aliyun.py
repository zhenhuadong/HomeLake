from openai import OpenAI
import os
from dotenv import load_dotenv
load_dotenv()

client = OpenAI(
    api_key=os.getenv("DASHSCOPE_API_KEY"),
    base_url="https://dashscope.aliyuncs.com/compatible-mode/v1",
)

# # response API 最新的的接口，适用于所有模型，推荐使用 
# response = client.responses.create(
#   model="qwen-plus",
#   input="Explain how AI works in a few words",
#   store=True,
# )

# print(response.output_text);

# completion API 适用于部分模型，后续会逐步废弃，不推荐使用
completion = client.chat.completions.create(
    model="qwen-plus",  # 此处以qwen-plus为例，可按需更换模型名称。模型列表：https://help.aliyun.com/zh/model-studio/getting-started/models
    messages=[{'role': 'system', 'content': 'You are a helpful assistant.'},
                {'role': 'user', 'content': 'Explain how AI works in a few words'}]
    )
# print(completion.model_dump_json())
print(completion.choices[0].message.content)