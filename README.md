# Honours-year-project-Transcribing-isiXhosa-SABC-broadcast-news-using-CMUSphinx
transcribePS.py is the python Pocketsphinx transcriber.
Sphinx4 is the java Sphinx4 transcriber.
IMPORTANT: Both these programs use a folder with wav files in to transcribe, so just make sure your input folder is like this.
Please change the paths of the models and input and output folder and file before using, otherwise you will get errors.

The models folder contains all the models needed for Sphinx4 and Pocketsphinx to work.

I have not added my code I used for the experiments or segmentation and preprocessing of data only the scripts to transcribe isiXhosa speech.
From my experiments it was clear that both Sphinx4 and Pocketsphinx for my models only works on seen data and cannot generalise for unseen data. Therefore this code will work on all the words present in the dictionary but not on words that aren't present.
