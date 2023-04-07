package pw.misa.kk6.Database;
import java.util.HashMap;
import java.util.List;

/**
 * Implementasi database sederhana, menggunakan java hashmap untuk menyimpan data. Dimana key hashmap yang digunakan adalah kode id dokumen/koleksi dan valuenya adalah isi dokumen atau isi koleksinya
 */
public class SimpleDB extends DatabaseConnection implements DocumentAccesable, CollectionsAccessable {

	private HashMap<String, String> idDocPassMap;

	private HashMap<String, String> idDocTitleMap;

	private HashMap<String, String> idDocContentMap;

	private HashMap<String, String> idColPassMap;

	private HashMap<String, String> idColTitleMap;

	private HashMap<String, List<String>> idColContentMap;


	/**
	 * @see Database.DocumentAccesable#createDocument(String, String)
	 */
	public String createDocument(String title, String text) {
		return null;
	}


	/**
	 * @see Database.DocumentAccesable#createDocument(String, String, String)
	 */
	public String createDocument(String title, String text, String docPass) {
		return null;
	}


	/**
	 * @see Database.DocumentAccesable#checkDocument(String)
	 */
	public boolean checkDocument(String docID) {
		return false;
	}


	/**
	 * @see Database.DocumentAccesable#checkDocument(String, String)
	 */
	public boolean checkDocument(String docID, String docPass) {
		return false;
	}


	/**
	 * @see Database.DocumentAccesable#getDocumentTitle(String)
	 */
	public String getDocumentTitle(String docID) {
		return null;
	}


	/**
	 * @see Database.DocumentAccesable#getDocumentText(String)
	 */
	public String getDocumentText(String docID) {
		return null;
	}


	/**
	 * @see Database.DocumentAccesable#updateDocumentTitle(String, String, String)
	 */
	public void updateDocumentTitle(String docID, String docPass, String newTitle) {

	}


	/**
	 * @see Database.DocumentAccesable#updateDocumentText(String, String, String)
	 */
	public void updateDocumentText(String docID, String docPass, String newContents) {

	}


	/**
	 * @see Database.DocumentAccesable#deleteDocument(String, String)
	 */
	public void deleteDocument(String docID, String docPass) {

	}


	/**
	 * @see Database.CollectionsAccessable#createCollection(String, )
	 */
	public String createCollection(String title, List<String> contents) {
		return null;
	}


	/**
	 * @see Database.CollectionsAccessable#createCollection(String, , String)
	 */
	public String createCollection(String title, List<String> contents, String colPass) {
		return null;
	}


	/**
	 * @see Database.CollectionsAccessable#checkCollection(String)
	 */
	public boolean checkCollection(String colID) {
		return false;
	}


	/**
	 * @see Database.CollectionsAccessable#checkCollection(String, String)
	 */
	public boolean checkCollection(String colID, String colPass) {
		return false;
	}


	/**
	 * @see Database.CollectionsAccessable#getCollectionTitle(String)
	 */
	public String getCollectionTitle(String colID) {
		return null;
	}


	/**
	 * @see Database.CollectionsAccessable#getCollectionContents(String)
	 */
	public List<String> getCollectionContents(String colID) {
		return null;
	}


	/**
	 * @see Database.CollectionsAccessable#updateCollectionTitle(String, String, String)
	 */
	public void updateCollectionTitle(String colID, String colPass, String newTitle) {

	}


	/**
	 * @see Database.CollectionsAccessable#updateCollectionContents(String, String, )
	 */
	public void updateCollectionContents(String colID, String colPass, List<String> newContents) {

	}


	/**
	 * @see Database.CollectionsAccessable#deleteCollection(String, String)
	 */
	public void deleteCollection(String colID, String colPass) {

	}

}