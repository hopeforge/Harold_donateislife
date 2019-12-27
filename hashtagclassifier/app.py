from preprocess import get_hashtags_from_text
from classifier import Classifier
from flask import Flask, session, escape, request, jsonify

app = Flask(__name__)
app.config['SECRET_KEY'] = "A0Zr98j/3yX R~XHH!jmN]LWX/,?RT"
classifier = Classifier()

@app.route('/twitt', methods=['GET', 'POST'])
def get_proba_twitt():
    global classifier
    if request.method == 'POST' or request.method == 'GET':
        if request.method == 'POST':
            if request.json:
                data = request.get_json()
                session['text'] = data['text']

            else:
                session['text'] = request.form['text']

        else:
            session['text'] = request.args.get('text')




        text = str(escape(session['text']))
        hashtags = get_hashtags_from_text(text)

        proba = classifier.classify(hashtags)
        response_ = {"proba": proba}
        return jsonify(response_)

if __name__ == "__main__":
    app.run(host='0.0.0.0', port=7777)
