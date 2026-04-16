from fastmcp import FastMCP
import logging

logging.basicConfig(level=logging.INFO, format="%(asctime)s - %(message)s")
logger = logging.getLogger("My Server")

# Initialize FastMCP
mcp = FastMCP("My Server")

# Add a tool
@mcp.tool()
def add(a: int, b: int) -> int:
    """Add two numbers"""
    logging.info(f"Adding {a} and {b}")
    return a + b

# add second tool
@mcp.tool()
def dream(content: str) -> str:
    """Nick dreams about something"""
    logging.info(f"Nick is dreaming about {content}")
    return f"Nick dreamed about {content}!"

if __name__ == "__main__":
    mcp.run()
