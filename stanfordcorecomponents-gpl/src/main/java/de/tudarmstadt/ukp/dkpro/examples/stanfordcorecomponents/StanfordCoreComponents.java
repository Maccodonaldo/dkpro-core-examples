package de.tudarmstadt.ukp.dkpro.examples.stanfordcorecomponents;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import de.tudarmstadt.ukp.dkpro.core.io.text.TextReader;
import de.tudarmstadt.ukp.dkpro.core.stanfordnlp.StanfordNamedEntityRecognizer;
import de.tudarmstadt.ukp.dkpro.core.stanfordnlp.StanfordParser;
import de.tudarmstadt.ukp.dkpro.core.stanfordnlp.StanfordSegmenter;
import org.apache.uima.UIMAException;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.collection.CollectionReader;
import org.apache.uima.fit.factory.JCasFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;
import org.apache.uima.jcas.JCas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngine;
import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngineDescription;
import static org.apache.uima.fit.factory.CollectionReaderFactory.createReader;

public class StanfordCoreComponents
{

    public static void main(String[] args)
            throws UIMAException, IOException
    {


    }

    public JCas run (String jsonString) throws UIMAException, IOException {
        // setup gson parser
        JsonParser jparser = new JsonParser();
        JsonElement jsonElement = jparser.parse(jsonString);
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        // get parameters out of the json object
        String language = jsonObject.get("language").toString();
        String text = jsonObject.get("text").toString();

        AnalysisEngine seg = createEngine(StanfordSegmenter.class);

        AnalysisEngine ner = createEngine(
                StanfordNamedEntityRecognizer.class);

        AnalysisEngine parser = createEngine(StanfordParser.class);

        AnalysisEngine writer = createEngine(NPNEWriter.class);

        List<AnalysisEngine> engines = new ArrayList<>();
        engines.add(seg);
        engines.add(ner);
        engines.add(parser);
        engines.add(writer);

        JCas jcas = process(text, language, engines);

        return jcas;
    }

    // return Jcas after iterated over all given engines
    private JCas process(String aText, String aLanguage, List<AnalysisEngine> engines) throws UIMAException {

        JCas jcas = JCasFactory.createText(aText, aLanguage);

        for (AnalysisEngine engine : engines)
            engine.process(jcas);

        return jcas;
    }

    /* main() */
} /* class */
