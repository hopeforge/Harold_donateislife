pip install rasa_nlu==0.14.0a1

pip install -r requirements.txt

python -m spacy download pt_core_news_sm

python -m rasa_nlu.server -c config.yml --path projects