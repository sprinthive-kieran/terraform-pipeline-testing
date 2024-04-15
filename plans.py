import os
import json
import subprocess


print(os.environ['envs'])
for i in json.loads(os.environ['envs']):
    currentEnv = i["name"]
    os.chdir(os.path.dirname(os.path.realpath(__file__)))
    print(currentEnv)
    os.chdir(f"envs/{currentEnv}")
    subprocess.call(["terraform", "init"])
    subprocess.call(["terraform", 'plan', '-out', f'../../plans/{currentEnv}.plan'])

