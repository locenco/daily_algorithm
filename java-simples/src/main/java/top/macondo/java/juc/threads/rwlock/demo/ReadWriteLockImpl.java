package top.macondo.java.juc.threads.rwlock.demo;

/**
 * @author: zhangchong
 * @Date: 2020/8/6 20:14
 **/
class ReadWriteLockImpl implements ReadWriteLock{

	private final Object MUTEX = new Object();

	private int writingWriters = 0;
	private int waitingWriters = 0;
	private int readingReaders = 0;

	private boolean preferWriter;

	public ReadWriteLockImpl() {
		this(true);
	}

	public ReadWriteLockImpl(boolean preferWriter) {
		this.preferWriter = preferWriter;
	}

	@Override
	public Lock readLock() {
		return new ReadLock(this);
	}

	@Override
	public Lock writeLock() {
		return new WriteLock(this);
	}
	void incrementWritingWriters(){
		this.writingWriters++;
	}
	void incrementWaitingWriters(){
		this.waitingWriters++;
	}
	void incrementReadingReaders(){
		this.readingReaders++;
	}
	void decrementWritingWriters(){
		this.writingWriters--;
	}
	void decrementWaitingWriters(){
		this.waitingWriters--;
	}
	void decrementReadingWriters(){
		this.readingReaders--;
	}

	@Override
	public int getWritingWriters() {
		return this.writingWriters;
	}

	@Override
	public int getReadingReaders() {
		return this.readingReaders;
	}

	@Override
	public int getWaitingWriters() {
		return this.waitingWriters;
	}

	Object getMUTEX(){
		return this.MUTEX;
	}
	boolean getPreferWriter(){
		return this.preferWriter;
	}
	void changePrefer(boolean preferWriter){
		this.preferWriter = preferWriter;
	}
}
