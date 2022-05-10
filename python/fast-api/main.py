from fastapi import FastAPI
from random import getrandbits

"""Made with FastAPI library

Use command to run:
$ uvicorn main:app --reload
"""

app = FastAPI()

@app.get("/")
def read_root():
    return {"Hello": "Team JABACAT"}


@app.get("/langs/{language}")
def read_lang(language):
    return {"is_good": language.lower() == "python" or not getrandbits(1)}

