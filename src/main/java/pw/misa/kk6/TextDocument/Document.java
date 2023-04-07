package pw.misa.kk6.TextDocument;

import pw.misa.kk6.Database.DocumentAccesable;
import pw.misa.kk6.Database.SimpleDB;

public class Document {

	private DocumentAccesable DocumentsAccess;

	private String DocumentID;

	private String DocumentPass;

	public String DocumentTitle;

	public String DocumentText;

	private SimpleDB simpleDB;

	private DocumentAccesable documentAccesable;

	public void Document(DocumentAccesable database) {

	}

	public void Document(DocumentAccesable database, String DocumentID) {

	}

	public void Document(DocumentAccesable database, String DocumentID, String DocumentPass) {

	}

	public void reload() {

	}

	public void save() {

	}

	public boolean isReadOnly() {
		return false;
	}

	public void loadPassword(String DocumentPass) {

	}

	public String getDocumentID() {
		return null;
	}

}
