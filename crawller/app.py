from flask import Flask,request,jsonify
import crawller

app = Flask(__name__)


@app.route('/crawller', methods=['GET', 'POST'])
def crawllerTweets():
    params = request.args.get("hashtags", default = "graacc", type= str)
    return crawller.write_tweets( params ).to_json(orient='records')

@app.route('/sendDirect', methods=['GET', 'POST'])
def sendDirect():
    id = request.args.get("id", type= int)
    text = request.args.get("text", type= str, default="Ajude o graacc")
    crawller.sendDirect(recipent=id, text=text) 
    return "OK"

if __name__ == '__main__':
    app.run(host='127.0.0.1', port='8081', debug=True)

