# This is a simple mcp "Hello World".
It includes a mcpserver built by fastmcp (high level framework on top of MCP SDK) with a greet tool and a mcpclient to call mcp server greet tool.

# how to start mcpserver and mcpclient

You need python 3.12.6+ pip 26.0.1+

## setup python venv
cd HomeLake/zhenhua.ai/mcp/python/modelcontextprotol

python -m venv .venv

### macOS/Linux
source .venv/bin/activate 

### Windows PowerShell
.\.venv\Scripts\Activate.ps1

## install dependency
pip install -r requirements.txt

## run server and client
python mcpserver.py

python mcpclient.py --name Zhenhua



