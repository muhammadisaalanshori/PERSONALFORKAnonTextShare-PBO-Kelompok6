package pw.misa.kk6.TextDocument;

import pw.misa.kk6.Database.DocumentAccesable;
import pw.misa.kk6.Database.SimpleDB;

public class Document {

	private DocumentAccesable DocumentsAccess;

	private String DocumentID;

	private String DocumentPass;

	public String DocumentTitle;

	public String DocumentText;
	public Document(DocumentAccesable database) {
            DocumentsAccess = database;
	}

	public Document(DocumentAccesable database, String DocumentID) {
            DocumentsAccess = database;
            this.DocumentID = DocumentID;
            reload();
	}

	public Document(DocumentAccesable database, String DocumentID, String DocumentPass) {
            DocumentsAccess = database;
            this.DocumentID = DocumentID;
            this.DocumentPass = DocumentPass;
            reload();
	}

	public void reload() {
            if (DocumentID != null && !DocumentID.equals("")) {
                if (DocumentsAccess.checkDocument(DocumentID)) {
                    DocumentTitle = DocumentsAccess.getDocumentTitle(DocumentID);
                    DocumentText = DocumentsAccess.getDocumentText(DocumentID);
                } else {
                    System.out.printf("Warning at %s: %s\n", this, "Document ID Not Found!");
                }
            } else {
                System.out.printf("Warning at %s: %s\n", this, "Document ID Empty");
            }
	}

	public void save() {
            if (DocumentID == null || DocumentID.equals("")) {
                if (DocumentPass == null || DocumentPass.equals("")) {
                    DocumentID = DocumentsAccess.createDocument(DocumentTitle, DocumentText);
                } else {
                    DocumentID = DocumentsAccess.createDocument(DocumentTitle, DocumentText, DocumentPass);
                }
            } else if (!isReadOnly()) {
                DocumentsAccess.updateDocumentTitle(DocumentID, DocumentPass, DocumentTitle);
                DocumentsAccess.updateDocumentText(DocumentID, DocumentPass, DocumentText);
            } else {
                System.out.printf("Warning at %s: %s\n", this, "Document Read Only!");
            }
	}

	public boolean isReadOnly() {
		if (DocumentID == null || DocumentID.equals("")) {
                    return false;
                } else if (DocumentPass != null && !DocumentPass.equals("")) {
                    return !DocumentsAccess.checkDocument(DocumentID, DocumentPass);
                } else {
                    return true;
                }
	}

	public void loadPassword(String DocumentPass) {
            this.DocumentPass = DocumentPass;
	}

	public String getDocumentID() {
            return DocumentID;
	}
        
        public static void main(String[] args) {
            DocumentAccesable db = new SimpleDB();
            Document newDocument = new Document(db);
            Document newDocumentWithPass = new Document(db);
            newDocumentWithPass.loadPassword("aGoodPassword");
            
            newDocument.DocumentTitle = "Hello World";
            newDocument.DocumentText = "This Document has no password, it will be read-only forever";
            newDocumentWithPass.DocumentTitle = "Hello World (But with a password this time)";
            newDocumentWithPass.DocumentText = "This Document has a password, it can be edited later";
            
            System.out.println("newDocument ReadOnly? " + newDocument.isReadOnly());
            System.out.println("newDocumentWithPass ReadOnly? " + newDocumentWithPass.isReadOnly());
            
            System.out.println("Saving and Reloading...");
            newDocument.save();
            newDocumentWithPass.save();
            newDocument.reload();
            newDocumentWithPass.reload();
            
            System.out.printf("== newDocument Contents:\nTitle: %s\nText: %s\n", newDocument.DocumentTitle, newDocument.DocumentText);
            System.out.printf("== newDocumentWithPass Contents:\nTitle: %s\nText: %s\n", newDocumentWithPass.DocumentTitle, newDocumentWithPass.DocumentText);
            
            
            System.out.println("newDocument ReadOnly? " + newDocument.isReadOnly());
            System.out.println("newDocumentWithPass ReadOnly? " + newDocumentWithPass.isReadOnly());
            
            
            System.out.println();
            Document readOnlyDocument = new Document(db, newDocument.getDocumentID());
            Document readWriteDocument = new Document(db, newDocumentWithPass.getDocumentID(), "aGoodPassword");
            
            System.out.printf("== readOnlyDocument Contents:\nTitle: %s\nText: %s\n", readOnlyDocument.DocumentTitle, readOnlyDocument.DocumentText);
            System.out.printf("== readWriteDocument Contents:\nTitle: %s\nText: %s\n", readWriteDocument.DocumentTitle, readWriteDocument.DocumentText);
            
            System.out.println("readOnlyDocument ReadOnly? " + readOnlyDocument.isReadOnly());
            System.out.println("readWriteDocument ReadOnly? " + readWriteDocument.isReadOnly());
            
            readOnlyDocument.DocumentTitle = "This should not work";
            readOnlyDocument.DocumentText = "It is Read Only";
            readWriteDocument.DocumentTitle = "Hello World (But its editable)";
            readWriteDocument.DocumentText = "This Document has a password, it can be edited later. Just like this!";
            
            
            System.out.printf("== readOnlyDocument Contents:\nTitle: %s\nText: %s\n", readOnlyDocument.DocumentTitle, readOnlyDocument.DocumentText);
            System.out.printf("== readWriteDocument Contents:\nTitle: %s\nText: %s\n", readWriteDocument.DocumentTitle, readWriteDocument.DocumentText);
            
            
            System.out.println("Saving and Reloading...");
            readOnlyDocument.save();
            readWriteDocument.save();
            readOnlyDocument.reload();
            readWriteDocument.reload();
            
            System.out.printf("== readOnlyDocument Contents:\nTitle: %s\nText: %s\n", readOnlyDocument.DocumentTitle, readOnlyDocument.DocumentText);
            System.out.printf("== readWriteDocument Contents:\nTitle: %s\nText: %s\n", readWriteDocument.DocumentTitle, readWriteDocument.DocumentText);
            
            System.out.println();
            newDocument.reload();
            newDocumentWithPass.reload();
            System.out.printf("== newDocument Contents:\nTitle: %s\nText: %s\n", newDocument.DocumentTitle, newDocument.DocumentText);
            System.out.printf("== newDocumentWithPass Contents:\nTitle: %s\nText: %s\n", newDocumentWithPass.DocumentTitle, newDocumentWithPass.DocumentText);
            
        }

}
