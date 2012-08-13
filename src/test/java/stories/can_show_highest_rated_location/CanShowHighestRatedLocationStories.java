package stories.can_show_highest_rated_location;

import stories.JBehaveStoryRunner;

public class CanShowHighestRatedLocationStories extends JBehaveStoryRunner {

    @Override
    public Object anInstanceOfMyStepsClass() {
        return new ShowHighestRatedLocationSteps();
    }

}