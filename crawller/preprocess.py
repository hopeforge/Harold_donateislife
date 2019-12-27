def get_hashtags_from_text(text):
    hashtags = []
    tokens = [x.lower() for x in text.split()]
    for x in tokens:
        if x[0] == '#':
            hashtags.append(x.replace('#', ''))
    return ' '.join(hashtags)
