from fastapi import FastAPI
from fastapi.openapi.utils import get_openapi
import yaml

app = FastAPI()

# 0. 下载 OpenAI 规范文件 (或者本地加载)
# https://github.com/openai/openai-python/blob/main/.stats.yml


# 1. 加载你的 YAML 文件
with open("openai_2_32_0.yml", "r", encoding="utf-8") as f:
    custom_schema = yaml.safe_load(f)

# 2. 覆盖 FastAPI 内部的 openapi 架构
app.openapi_schema = custom_schema

# 3. 手动定义 /docs 路由
@app.get("/docs", include_in_schema=False)
async def custom_swagger_ui_html():
    return get_swagger_ui_html(
        openapi_url="/openapi.json",  # 告诉 Swagger 去哪里找描述文件
        title=app.title + " - Swagger UI",
    )

# 4. 手动定义 /openapi.json 路由（Swagger 必须读取这个 JSON）
@app.get("/openapi.json", include_in_schema=False)
async def get_open_api_endpoint():
    return custom_schema

if __name__ == "__main__":
    import uvicorn
    uvicorn.run(app, host="127.0.0.1", port=8000)
