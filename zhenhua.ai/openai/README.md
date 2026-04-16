
cd zhenhua.ai/openai 
source .venv/bin/activate
pip install -r requirements.txt
python gemini_demo.py 
python openai_demo.py
python aliyun_demo.py

unset HTTP_PROXY  HTTPS_PROXY NO_PROXY

export HTTP_PROXY="http://127.0.0.1:6789"
export HTTPS_PROXY="http://127.0.0.1:6789"
export NO_PROXY="localhost,127.0.0.1,.internal.local"

% env | grep -i proxy
HTTP_PROXY=http://127.0.0.1:6789
HTTPS_PROXY=http://127.0.0.1:6789
NO_PROXY=localhost,127.0.0.1,.internal.local
