package laboratorio;

public class NormalStrategy implements WarStrategy {
	private CoDicRobot self;
	private int time = 0;
	private int positions[] = { 79, -51, 75, 141, 125, -129, 100, -141};
	
	public NormalStrategy(CoDicRobot robot) {
		self = robot;
	}
	
	public void handle() {
		if (time == 8) { 
			time = 0;
		}
		handleMove();
		time += 2;
	}
	
	public void handleMove() {
		if (positions[time+1] > 0) {
			self.turnRight(positions[time+1]);
		} else {
			self.turnLeft(-positions[time+1]);
		}
		self.ahead(positions[time]);
	}
	
	public void handleAtack( ) {
		if (self.gunReady) {
			self.turnGunTo(self.scannedAngle);
			self.fire(0.5);
		}
	}

	public void handleHit() {
		self.back(25);
	}
	public void handleWall() {
		self.back(100);
	}
	
}
