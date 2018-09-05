package laboratorio;

public class WarStrategist {
	private static WarStrategist instance = new WarStrategist();
	
	private WarStrategist() {}
	
	public WarStrategist getStrategist() {
		return instance;
	}
	
	private WarStrategy getNormalStrategyForRobot(CoDicRobot robot) {
		return new WarStrategy() {
			
			private int time = 0;
			private int positions[] = { 79, -51, 75, 141, 125, -129, 100, -141};

			@Override
			public void handleMove() {
				if (time == 8) { 
					time = 0;
				}
				
				if (positions[time + 1] > 0) {
					robot.turnRight(positions[time + 1]);
				} else {
					robot.turnLeft(-positions[time + 1]);
				}
				
				robot.ahead(positions[time]);
				time += 2;
			}

			@Override
			public void handleAtack() {
				if (!robot.gunReady) {
					return;
				}
				
				robot.turnGunTo(robot.scannedAngle);
				robot.fire(0.5);
			}

			@Override
			public void handleHit() {
				robot.back(25);
			}

			@Override
			public void handleWall() {
				robot.back(100);
			}
			
		};
	}
	
	private WarStrategy getWarningStrategyForRobot(CoDicRobot robot) {
		return new WarStrategy() {

			@Override
			public void handleMove() {
				robot.turnAheadRight(1000, 5);
			}

			@Override
			public void handleAtack() {
				robot.turnGunTo(robot.scannedAngle);
				robot.fire(robot.energy / 15);
			}

			@Override
			public void handleHit() {
				robot.back(10);
			}

			@Override
			public void handleWall() {
				robot.back(100);
			}
			
		};
	}
	
	public static WarStrategy getStrategyForRobot(CoDicRobot robot) {
		if (robot.energy <= 20) {
			return instance.getWarningStrategyForRobot(robot);
		}
		
		return instance.getNormalStrategyForRobot(robot);
	}
}
