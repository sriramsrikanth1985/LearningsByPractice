package file;

import static java.security.AccessController.doPrivileged;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.Paths;

import sun.security.action.GetPropertyAction;

public class FileLockExampleFile2 {
	public static void main(String[] args) throws IOException,InterruptedException {
		// A test file for locking has been created in FileLockExampleFile1.
		// Please run that file before running this.
		//Path tempDir=Paths.get(doPrivileged(new GetPropertyAction("C:\\")));
		File file = new File("C:\\D Drive" + File.separator+ "testLocking.txt");
		file.createNewFile();
		RandomAccessFile rf = new RandomAccessFile(file, "rw");
		FileChannel fileChannel = rf.getChannel();
		// let us try to get a lock. FileLockExampleFile1 has an exclusive lock
		// so this call will block till FileLockExampleFile1 releases lock
		System.out.println("Trying to acquire lock");
		FileLock lock = fileChannel.tryLock();
		if(lock == null)
			System.out.println("Cannot accuire a lock since other process accuired it already");
		else {
			System.out.println("file lock acquired");
			lock.release();
		}
	}
}