import os
import json
print(os.environ['envs'])
for i in json.loads(os.environ['envs']):
    print(i)
