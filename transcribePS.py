import os
from pocketsphinx import AudioFile, Pocketsphinx

def transcribe_audio(hmm, lm, dic, audio_file):
    config = {
        'verbose': False,
        'audio_file': audio_file,
        'buffer_size': 2048,
        'no_search': False,
        'full_utt': True,  # Transcribe the full utterance
        'hmm': hmm,
        'lm': lm,
        'dict': dic
    }

    speech = AudioFile(**config)

    transcription = ""
    for phrase in speech:
        print(phrase)
        transcription += str(phrase) + " "
    
    return transcription

def main():
    hmm = 'isixhosa.cd_cont_200'  # Acoustic model
    lm = 'isixhosa.lm.bin'  # Language model
    dic = 'isixhosa.dic'  # The phonetic dictionary
    input_folder = 'final_segments_6'  # Folder containing audio files
    output_file = 'transcriptPS_6.txt'  # The output transcript file


    # Get a sorted list of '.wav' files in the folder
    wav_files = sorted([file_name for file_name in os.listdir(input_folder) if file_name.endswith('.wav')])

    with open(output_file, 'w') as file:
        for file_name in wav_files:
            if file_name in wav_files:
                audio_file = os.path.join(input_folder, file_name)
                transcription = transcribe_audio(hmm, lm, dic, audio_file)
                file.write(transcription + "\n")

if __name__ == "__main__":
    main()
