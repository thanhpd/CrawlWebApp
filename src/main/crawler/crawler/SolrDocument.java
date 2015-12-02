package crawler;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.common.SolrInputDocument;

public class SolrDocument {
	private static final String FIELD_ID_FILE = "IdFile";
	private static final String FIELD_ID_TITLE = "title";
	private static final String FIELD_CONTENT = "content";
	private static final String FIELD_ID_SENTENCE = "IDSentence";
	private static final String FIELD_ID_PARAGRAPH = "IDParagraph";
	private static final String FIELD_ID_WORD_BEGIN = "IDWordBegin";
	private static final String FIELD_ID_WORD_END = "IDWordEnd";

	public static List<SolrInputDocument> createSolrDocument(RawDocument rawDoc) {
		List<SolrInputDocument> res = new ArrayList<SolrInputDocument>();

		BreakIterator sentBreak = BreakIterator.getSentenceInstance();
		String text = rawDoc.getContent();
		sentBreak.setText(text);

		int sentCounter = 0, paraCounter = 0;
		int begin, end;
		begin = sentBreak.first();
		while (begin != BreakIterator.DONE) {
			end = sentBreak.next();
			if (end != BreakIterator.DONE && end - begin > 10) {

				SolrInputDocument doc = new SolrInputDocument();
				
				doc.addField(FIELD_ID_TITLE, rawDoc.getTitle());
				doc.addField(FIELD_ID_FILE, rawDoc.getLink());
				doc.addField(FIELD_CONTENT, text.substring(begin, end));
				doc.addField(FIELD_ID_SENTENCE, sentCounter);
				doc.addField(FIELD_ID_PARAGRAPH, paraCounter);
				doc.addField(FIELD_ID_WORD_BEGIN, begin);
				doc.addField(FIELD_ID_WORD_END, end);

				res.add(doc);

				sentCounter++;
				if (text.charAt(end - 1) == '\n')
					paraCounter++;
			}
			begin = end;
		}

		return res;
	}
}
