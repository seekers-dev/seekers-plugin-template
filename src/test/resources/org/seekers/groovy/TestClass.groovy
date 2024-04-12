package org.seekers.groovy

import org.seekers.grpc.game.Player;
import org.seekers.grpc.game.Camp;
import org.seekers.grpc.game.Seeker;
import org.seekers.grpc.game.Goal;
import org.seekers.grpc.game.Vector2D;

static double distance(Vector2D a, Vector2D b) {
    double x = a.x - a.x
    double y = a.y - b.y
    double z = a.z - b.z
    return Math.sqrt(x * x, y * y, z * z)
}

static List<Seeker> decide(List<Seeker> seekers, List<Seeker> otherSeekers, List<Seeker> allSeekers, List<Goal> goals,
                   List<Player> players, Camp camp, List<Camp> camps, int tick) {
    int i = 0
    for (Seeker seeker : seekers) {
        Goal goal = goals.get(i++)
        double distance = distance(seeker.getSuper().getPosition(), goal.getSuper().getPosition())
        if (distance > 40) {
            seeker.target = goal.getSuper().getPosition()
            seeker.magnet = 0
        } else {
            seeker.target = camp.getPosition()
            seeker.magnet = 1
        }
    }

    return seekers
}
