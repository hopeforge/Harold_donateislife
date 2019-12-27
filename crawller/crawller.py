import tweepy
from tweepy import Stream
from tweepy import OAuthHandler
from tweepy.streaming import StreamListener
import json
import pandas as pd
from classifier import Classifier

from pandas.io.json import json_normalize

import csv
import re  # regular expression

# Twitter credentials for the app
consumer_key = 'b0Mp2hczge9oIhwLTHvXaYGY0'
consumer_secret = 'HaL5zMnpe0PJ0YsBDNYPIFOTEZpqdRok7tqGEtajhh425wThBW'
access_key = '58998497-RPJZlqbrmnN35TZ3pOZJ3rMR82rzeWumPipqfM2HA'
access_secret = 'EtzjpDB2NV7YnTQzX2WBhTW44LugETZwao4bexykU4GoO'

auth = tweepy.OAuthHandler(consumer_key, consumer_secret)
auth.set_access_token(access_key, access_secret)
api = tweepy.API(auth)

start_date = '2019-01-01'
end_date = '2019-12-31'


def sendDirect(recipent, text):
    return api.send_direct_message(recipient_id=recipent, text=text)


def write_tweets(keyword):
    data = {
        'search_phrase': [],
        'text': [],
        'screen_name': [],
        'created_at': [],
        'retweet_count': [],
        'favorite_count': [],
        'friends_count': [],
        'followers_count': [],
        'user_id': [],
        'user_name': [],
        'user_location': [],
        'user_description': [],
        'probability': []
    }

    # HashTag Classifier
    classifier = Classifier()

    # page attribute in tweepy.cursor and iteration
    for page in tweepy.Cursor(api.search, q=keyword,
                              count=100, include_rts=True, since=start_date).pages(10):
        for status in page:
            status = status._json
            if status['lang'] != 'pt':
                continue
            print(status['text'])
            data['text'].append(status['text'])
            data['screen_name'].append(status['user']['screen_name'])
            data['created_at'].append(status['created_at'])
            data['retweet_count'].append(status['retweet_count'])
            data['favorite_count'].append(status['favorite_count'])
            data['friends_count'].append(status['user']['friends_count'])
            data['followers_count'].append(status['user']['followers_count'])

            data['user_id'].append(status['user']['id'])
            data['user_name'].append(status['user']['name'])
            data['user_location'].append(status['user']['location'])
            data['user_description'].append(status['user']['description'])
            data['probability'].append(classifier.classify(status['text']))

    return pd.DataFrame.from_dict(data, orient='index').transpose()