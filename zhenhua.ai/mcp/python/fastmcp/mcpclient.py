#!/usr/bin/env python3
import argparse
import asyncio
from typing import Any
from fastmcp import Client
from fastmcp.client.transports import StreamableHttpTransport

def _extract_text(result: Any) -> str:
    """Best effort to extract text for MCP call_tool result text."""
    content = getattr(result, "content", None)
    if not content:
        return str(result)
    
    parts: list[str] = []
    for item in content:
        text = getattr(item, "text", None)
        if text:
            parts.append(text)
        else:
            parts.append(str(item))
    return "\n".join(parts)

async def call_greet(base_url: str, name: str) -> None:
    # FastMCP streamable-http default endpoint is usually mcp
    endpoint = base_url.rstrip("/") + "/mcp"

    transport = StreamableHttpTransport(url=endpoint)
    
    async with Client(transport=transport) as client:
        await client.ping()
        tools = await client.list_tools()
        tool_names = [tool.name for tool in tools]
        print(f"Available tools: {tool_names}")
        
        result = await client.call_tool("greet", {"name": name})
        text = _extract_text(result)
        print(f"Result: {text}")


if __name__ == "__main__":
    parser = argparse.ArgumentParser(description="MCP Client Example")
    parser.add_argument("--base-url", type=str, default="http://localhost:8000", help="Base URL of the MCP server")
    parser.add_argument("--name", type=str, default="World", help="Name to greet")
    args = parser.parse_args()

    asyncio.run(call_greet(args.base_url, args.name))
