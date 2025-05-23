def count_letters(st):
    letters = {}
    for char in st:
        letters[char] = letters.get(char, 0) + 1
    return letters

frost = open('frost.txt', 'r')
text = frost.read()
print(text.upper())
letter_freqs = count_letters(text.upper())
output = ''
for k in sorted(letter_freqs, key=lambda k: letter_freqs[k], reverse=True):
    output += ("{} : {}\n".format(k, letter_freqs[k]))

results = open('results.txt', 'w')
results.write(output)

results.close()
frost.close()
# print(letter_freqs)