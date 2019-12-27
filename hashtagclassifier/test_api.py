import requests
import argparse
import sys

def teste_post(texto):

    resp = requests.post('http://localhost:7777/twitt',
                         data={'text': texto},
                         cookies={'from-my': 'browser'})
    print(resp.json())

def parse_args(args):
    """ Parse the arguments.
    """
    parser = argparse.ArgumentParser(description='Predict script')


    parser.add_argument("--text", default=None, type=str)




    return parser.parse_args(args)

if __name__ == '__main__':
    args = sys.argv[1:]
    args = parse_args(args)
    teste_post(args.text)
