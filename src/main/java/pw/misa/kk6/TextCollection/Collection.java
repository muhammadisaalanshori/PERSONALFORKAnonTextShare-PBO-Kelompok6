package pw.misa.kk6.TextCollection;
import java.util.List;
import pw.misa.kk6.Database.CollectionsAccessable;
import pw.misa.kk6.Database.SimpleDB;
import pw.misa.kk6.TextDocument.Document;

public class Collection {

	private CollectionsAccessable CollectionsAccess;

	private String CollectionID;

	private String CollectionPass;

	public String CollectionTitle;

	public List<Document> CollectionContents;

	private SimpleDB simpleDB;

	private CollectionsAccessable collectionsAccessable;

	public void Collection(CollectionsAccessable database) {

	}

	public void Collection(CollectionsAccessable database, String CollectionID) {

	}

	public void Collection(CollectionsAccessable database, String CollectionID, String CollectionPass) {

	}

	public void reload() {

	}

	public void save() {

	}

	public boolean isReadOnly() {
		return false;
	}

	public void loadPassword(String CollectionPass) {

	}

	public String getCollectionID() {
		return null;
	}

}
