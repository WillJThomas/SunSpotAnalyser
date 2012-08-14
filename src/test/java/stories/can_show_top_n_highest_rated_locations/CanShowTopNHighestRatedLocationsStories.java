package stories.can_show_top_n_highest_rated_locations;

import stories.JBehaveStoryRunner;

public class CanShowTopNHighestRatedLocationsStories extends JBehaveStoryRunner {

    @Override
    public Object anInstanceOfMyStepsClass() {
        return new ShowTopNHighestRatedLocationsSteps();
    }

}