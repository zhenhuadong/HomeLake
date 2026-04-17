from pathlib import Path
import subprocess

def main() -> None:
    folder = Path(".")
    demo_files = list(folder.glob("demo*.py"))
    print(f"available demo files: {demo_files}")
    for demo in demo_files:
        print(f"正在执行: {demo.name}")
        subprocess.run(["python", str(demo)])

if __name__ == "__main__":
    main()

