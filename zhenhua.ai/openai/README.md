
cd zhenhua.ai/openai 
source .venv/bin/activate
pip install -r requirements.txt

create .env for your api_key, such as
OPENAI_API_KEY="<your_api_key>"
GEMINI_API_KEY="<your_api_key>"
DASHBOARD_API_KEY="<your_api_key>"

python demo_gemini.py 
python demo_openai.py
python demo_aliyun.py
python main.py

unset HTTP_PROXY  HTTPS_PROXY NO_PROXY

export HTTP_PROXY="http://127.0.0.1:6789"
export HTTPS_PROXY="http://127.0.0.1:6789"
export NO_PROXY="localhost,127.0.0.1,.internal.local"

% env | grep -i proxy
HTTP_PROXY=http://127.0.0.1:6789
HTTPS_PROXY=http://127.0.0.1:6789
NO_PROXY=localhost,127.0.0.1,.internal.local
