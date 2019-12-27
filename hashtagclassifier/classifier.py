import pickle


class Classifier():
    def __init__(self):
        with open('./hashtagclassifier/model/hashtag_classifier.pck', 'rb') as training_model:
            self.model = pickle.load(training_model)

        with open('./hashtagclassifier/model/vectorizer.pck', 'rb') as training_model:
            self.vectorizer = pickle.load(training_model)

    def classify(self, input):
        text = self.vectorizer.transform([input])
        proba = self.model.predict_proba(text)
        return proba[0][1]
