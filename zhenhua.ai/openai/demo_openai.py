from openai import OpenAI
from dotenv import load_dotenv
load_dotenv()

client = OpenAI()

# response API 最新的的接口，适用于所有模型，推荐使用
response = client.responses.create(
  model="gpt-5-nano",
  input="Explain how AI works in a few words",
  store=True,
)

print(response.output_text);

# # completion API 适用于部分模型，后续会逐步废弃，不推荐使用
# completion = client.chat.completions.create(
#     model="gpt-5-nano", 
#     messages=[{'role': 'system', 'content': 'You are a helpful assistant.'},
#                 {'role': 'user', 'content': 'Explain how AI works in a few words'}]
#     )

# print(completion.choices[0].message.content)