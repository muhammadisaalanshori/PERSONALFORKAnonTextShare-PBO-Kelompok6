package pw.misa.kk6.Database;

public abstract interface DocumentAccesable {

	public abstract String createDocument(String title, String text);

	public abstract String createDocument(String title, String text, String docPass);

	public abstract boolean checkDocument(String docID);

	public abstract boolean checkDocument(String docID, String docPass);

	public abstract String getDocumentTitle(String docID);

	public abstract String getDocumentText(String docID);

	public abstract void updateDocumentTitle(String docID, String docPass, String newTitle);

	public abstract void updateDocumentText(String docID, String docPass, String newContents);

	public abstract void deleteDocument(String docID, String docPass);

}
