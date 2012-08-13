package stories.can_calculate_solar_activitiy_score;

import stories.JBehaveStoryRunner;

public class CanCalculateSolarActivityScoreStories extends JBehaveStoryRunner {

    @Override
    public Object anInstanceOfMyStepsClass() {
        return new CalculateSolarActivityScoreSteps();
    }
}