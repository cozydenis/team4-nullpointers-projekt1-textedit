package TextEditor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChristmasEgg {
    List<String> bedStory = new ArrayList<>();
    String aTale = "The Great Hall at Hogwarts School of Witchcraft and Wizardry was abuzz with excitement as the students prepared for another year. The Sorting Hat had just finished its annual song, and the first years anxiously awaited their fate. Among the sea of faces, there was an unfamiliar one - a young girl with striking green eyes and unruly black hair. The teachers exchanged puzzled glances as Professor McGonagall approached the mysterious newcomer. \"I don't recall any additional students being enrolled,\" she mused. The girl introduced herself as Lily Blackwood and claimed she had just discovered her magical abilities. The professors exchanged skeptical glances, but Headmistress McGonagall decided to allow her to join the Gryffindor table until her situation could be sorted out. As the days passed, whispers circulated through the castle about Lily Blackwood's mysterious background. Some claimed she was the long-lost heir to a powerful wizarding family, while others believed she was a dark witch seeking refuge. Harry, Ron, and Hermione were intrigued and decided to investigate. Late one night, they sneaked into the restricted section of the library to search for clues. To their surprise, they found a dusty old book detailing a prophecy about a lost heir who would bring balance to the wizarding world. The trio realized that Lily might be the key to a greater destiny. Lily's time at Hogwarts was filled with challenges as she struggled to prove herself amidst the rumors and skepticism. However, she formed a close bond with Harry, Ron, and Hermione, who became her loyal companions. Together, they delved deeper into the mysteries surrounding Lily's heritage. They uncovered a hidden chamber within the castle, protected by powerful enchantments. Inside, they found a portrait of Lily's parents, confirming her magical lineage. The trio also discovered a series of ancient spells that only Lily could perform, each unlocking a new piece of her true identity. As Lily embraced her destiny, dark forces began to stir. An ancient dark wizard, thought to be vanquished, rose once more, seeking the power that belonged to Lily. The trio, along with other allies, faced formidable challenges and dangerous adversaries as they tried to prevent the dark wizard's return to power. The tension at Hogwarts reached its peak as the dark wizard's forces descended upon the castle. Lily, Harry, Ron, and Hermione stood together, facing the ultimate battle between good and evil. With the power of friendship, love, and the ancient spells passed down through her family, Lily confronted the dark wizard in a duel that shook the foundations of the magical world. In the end, the light triumphed, and the dark wizard was once again defeated. Lily Blackwood's true heritage was revealed to all, and she became a symbol of hope and unity for the wizarding world. With the dark forces vanquished, Hogwarts flourished once again. Lily, Harry, Ron, and Hermione graduated, knowing they had played a crucial role in preserving the magical balance. The whispers of the lost heir faded away, leaving behind a legacy of courage, friendship, and the enduring magic of Hogwarts.";
    int placeOfText = 0;
    public ChristmasEgg(){
        bedStory.add("In the dark, snowy town of Binaryville, young Jack Jingle discovered the magic of computer science. His code-powered sleigh lit up the night, delivering joy to every corner. The townsfolk marveled at the algorithmic wonders, realizing that in the language of ones and zeros, holiday miracles unfolded.");
        bedStory.add("Sally Sparkle, a peculiar inventor in a quirky workshop, embraced the eccentricity of computer science. Her festive gadgets, adorned with blinking LEDs, transformed the ordinary into the extraordinary. In the town square, a pixelated Christmas tree beamed with pixel perfection, showcasing the enchantment of coding creativity.");
        bedStory.add("Meet Edgar Eggnog, a computer scientist with a penchant for the peculiar. In his workshop, he brewed algorithms instead of potions. Edgar's automated gingerbread factory, guided by meticulous coding spells, produced confections that danced to the rhythm of festive algorithms, making the season sweeter for everyone.");
        bedStory.add("In a town draped in shadows and tinsel, Wendy Wondersmith cast a spell of logic and algorithms. Her enchanted computer, adorned with gothic ornaments, weaved a tapestry of efficiency through the town. The gift of systematic problem-solving became the most cherished present, turning Christmas into a celebration of computational enchantment.");
        bedStory.add("The Clockwork Carolers, a group of automaton minstrels, brought a mechanical symphony to Yuletide festivities. Crafted by the brilliant mind of Professor Geargrind, these robotic musicians showcased the harmony of computer science. Their precision and synchronization turned the town square into a mesmerizing spectacle, proving that in the gears and circuits, holiday magic found its rhythm.");

    }

    public String retriveBedTimeStory() {

    Random rand = new Random();
    int randomNumber = rand.nextInt(bedStory.size());

    return bedStory.get(randomNumber);

    }

    public String retriveApartOfaTale() {
        // Split the tale into sentences
        String[] sentences = aTale.split("\\.");

        // Ensure we are within bounds
        if (placeOfText < sentences.length) {
            // Get the sentence at the current position
            String sentence = sentences[placeOfText];

            // Move to the next sentence for the next call
            placeOfText++;

            return sentence.trim();  // Trim to remove leading/trailing spaces
        } else {
            // Reset to the beginning if we reach the end
            placeOfText = 0;
            return retriveApartOfaTale();
        }
    }
}
