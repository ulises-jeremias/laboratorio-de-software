package laboratorio;

public class WarningStrategy implements WarStrategy {
	private CoDicRobot self;

	public WarningStrategy(CoDicRobot robot) {
		self = robot;
	}
	
	public void handle() {
		handleMove();
	}
	
	public void handleMove() {
		self.turnAheadRight(1000, 5);
	}
	
	public void handleAtack() {
		self.turnGunTo(self.scannedAngle);
		self.fire(self.energy/15);
	}
	
	public void handleHit() {
		self.back(10);
	}
	public void handleWall() {
		self.back(100);
	}
}
