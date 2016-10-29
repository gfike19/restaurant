
public abstract class Entity {
	private static int uid;
	
	public Entity (int id) {
		final int uid = id;
	}

	public static int getUid() {
		return uid;
	}

}
