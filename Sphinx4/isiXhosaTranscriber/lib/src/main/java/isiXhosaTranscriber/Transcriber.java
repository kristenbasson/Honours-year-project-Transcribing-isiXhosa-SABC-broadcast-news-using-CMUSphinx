package isiXhosaTranscriber;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.StreamSpeechRecognizer;

public class Transcriber {

    public static void main(String[] args) throws Exception {

        Configuration configuration = new Configuration();

        configuration.setAcousticModelPath("/models/isixhosa.cd_cont_200");
        configuration.setDictionaryPath("/models/isixhosa.dic");
        configuration.setLanguageModelPath("/models/isixhosa.lm.bin");

//        SPECIFY PATH TO INPUT FOLDER TO TRANSCRIBE
        File inputFolder = new File("/UCT/project/Experiments/final_segments_8");
        File[] audioFiles = inputFolder.listFiles((dir, name) -> name.endsWith(".wav"));
        Arrays.sort(audioFiles, Comparator.comparing(File::getName));
        
//      SPECIFY PATH TO OUTPUT TEXT FILE TO WRITE TRANSCRIPTION
        FileWriter writer = new FileWriter("transcript_8.txt");

        for (File audioFile : audioFiles) {
            InputStream stream = new FileInputStream(audioFile);

            StreamSpeechRecognizer recognizer = new StreamSpeechRecognizer(configuration);
            recognizer.startRecognition(stream);

            StringBuilder transcriptionBuilder = new StringBuilder();

            SpeechResult result;
            while ((result = recognizer.getResult()) != null) {
                String transcription = result.getHypothesis();
                transcriptionBuilder.append(transcription).append(" ");
            }

            writer.write(transcriptionBuilder.toString().trim() + "\n"); // Write the transcription and add a line break

            recognizer.stopRecognition();
        }

        // Close the FileWriter
        writer.close();
    }
}
//KRISTEN BASSON BSSKRI003
