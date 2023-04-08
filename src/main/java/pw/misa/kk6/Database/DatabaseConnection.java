package pw.misa.kk6.Database;

abstract public class DatabaseConnection implements DocumentAccesable, CollectionsAccessable {
        public static void main(String[] args) {
            DatabaseConnection db = new SimpleDB();
            
            // Membuat dokumen tanpa password
            System.out.println("Membuat dokumen tanpa password");
            String docNoPass = db.createDocument("Hello World", "Hello World is a common test program usually used by programmers to test that their software is working");
            System.out.println("docNoPass ID: " + docNoPass);
            
            // Cek Dokumen dan isinya
            System.out.println("\nCek Dokumen dan isinya");
            System.out.println("docNoPass Exists?: " + db.checkDocument(docNoPass));
            System.out.println("random document Exists?: " + db.checkDocument("1233312"));
            System.out.println("docNoPass password Check?: " + db.checkDocument(docNoPass, null));
            System.out.println("docNoPass Title: " + db.getDocumentTitle(docNoPass));
            System.out.println("docNoPass Text: " + db.getDocumentText(docNoPass));
            
            // Mencoba mengupdate dokumen tanpa password
            System.out.println("\nMencoba mengupdate dokumen tanpa password");
            System.out.println("docNoPass update Title: " + db.updateDocumentTitle(docNoPass, "password", "Goodbye world"));
            System.out.println("docNoPass update Text: " + db.updateDocumentText(docNoPass, "", "Goodbye cruel world"));
            System.out.println("docNoPass Title: " + db.getDocumentTitle(docNoPass));
            System.out.println("docNoPass Text: " + db.getDocumentText(docNoPass));
            
            // Mencoba menghapus dokumen tanpa password
            System.out.println("\nMencoba menghapus dokumen tanpa password");
            System.out.println("docNoPass delete: " + db.deleteDocument(docNoPass, null));
            System.out.println("docNoPass Exists?: " + db.checkDocument(docNoPass));
            System.out.println("docNoPass Title: " + db.getDocumentTitle(docNoPass));
            System.out.println("docNoPass Text: " + db.getDocumentText(docNoPass));
            
            System.out.println("============================================================");

            // Membuat dokumen dengan password
            System.out.println("Membuat dokumen tanpa password");
            String docWithPass = db.createDocument("A New Document", "This is a new document with a password", "goodPassword");
            System.out.println("docWithPass ID: " + docWithPass);
            
            // Cek Dokumen dan isinya
            System.out.println("\nCek Dokumen dan isinya");
            System.out.println("docWithPass Exists?: " + db.checkDocument(docWithPass));
            System.out.println("docWithPass password Check?: " + db.checkDocument(docWithPass, "goodPassword"));
            System.out.println("docWithPass wrong password Check?: " + db.checkDocument(docWithPass, "veryBadPassword123"));   
            System.out.println("docWithPass null password Check?: " + db.checkDocument(docWithPass, null));
            System.out.println("docWithPass Title: " + db.getDocumentTitle(docWithPass));
            System.out.println("docWithPass Text: " + db.getDocumentText(docWithPass));
            
            // Mencoba mengupdate dokumen
            System.out.println("\nMencoba mengupdate dokumen");
            System.out.println("dengan password yang salah");
            System.out.println("docWithPass update Title: " + db.updateDocumentTitle(docWithPass, "password", "kena hack"));
            System.out.println("docWithPass update Text: " + db.updateDocumentText(docWithPass, "", "ceritanya ada yang coba hack gitu"));
            System.out.println("docWithPass Title: " + db.getDocumentTitle(docWithPass));
            System.out.println("docWithPass Text: " + db.getDocumentText(docWithPass));
            System.out.println("dengan password yang benar");
            System.out.println("docWithPass update Title: " + db.updateDocumentTitle(docWithPass, "goodPassword", "Halo Dunia"));
            System.out.println("docWithPass update Text: " + db.updateDocumentText(docWithPass, "goodPassword", "Ini adalah isi baru teks dokumen ini"));
            System.out.println("docWithPass Title: " + db.getDocumentTitle(docWithPass));
            System.out.println("docWithPass Text: " + db.getDocumentText(docWithPass));
            
            // Mencoba menghapus dokumen tanpa password
            System.out.println("\nMencoba menghapus dokumen yang dipassword");
            System.out.println("docWithPass delete wrong password: " + db.deleteDocument(docWithPass, null));
            System.out.println("docWithPass Exists?: " + db.checkDocument(docWithPass));
            System.out.println("docWithPass Title: " + db.getDocumentTitle(docWithPass));
            System.out.println("docWithPass Text: " + db.getDocumentText(docWithPass));
            System.out.println("docWithPass delete: " + db.deleteDocument(docWithPass, "goodPassword"));
            System.out.println("docWithPass Exists?: " + db.checkDocument(docWithPass));
            
        }
        
        protected static String genID() {
            return String.valueOf((long) (Math.random() * 1e16));
        }
        
}
