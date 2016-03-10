package interview.blog;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

public class Populator
{
    public void populate( BlogDB db ){
        //01 February 1845
        long ravenDate = new LocalDate( 1845, 2, 1 ).toDate().getTime();
        BlogPost raven = new BlogPost( null, "The Raven", ravenDate, "Edgar Allan Poe", "aep@deadpoetssociety.com", ravenQuote(), raven() );
        db.store( raven );
        
        // 26 November 1865
        long jabberDate = new LocalDate( 1865, 11, 26 ).toDate().getTime();
        BlogPost jabber = new BlogPost( null, "The Jabberwocky", jabberDate, "Lewis Carroll", "lewis@wonderland.net", jabberwockyQuote(), jabberwocky() );
        db.store( jabber );
    }
    
    public static String shortLoremIpsum() {
        return "Lorem ipsum dol amet sitor, consectetuer adipiscing elit. Donec dui. Integer tortor. Praesent adipiscing nibh sit amet lacus.";
    }
    
    public static String loremIpsum() {
        return "Lorem ipsum dol amet sitor, consectetuer adipiscing elit. Donec dui. Integer tortor. Praesent adipiscing nibh sit amet lacus. Ut ut lorem et mi dignissim condimentum. Maecenas ac lectus quis pede dictum tempor. Proin convallis pede non lacus. Etiam nonummy arcu sit amet justo. Nulla et magna a justo mollis venenatis. Donec eros. Praesent luctus urna sed mauris. Aliquam ultrices. Donec imperdiet, mi eu consequat sollicitudin, diam erat molestie nulla, sit amet molestie ligula orci quis pede. Morbi pretium augue vel nibh. Donec et urna eget lacus aliquet fringilla. Praesent fringilla massa nec magna. Nunc sodales sem a dolor. Ut congue, risus fermentum sagittis lacinia, odio ligula vestibulum leo, eu sollicitudin lacus est vel mi. Quisque eros tellus, laoreet vel, convallis id, cursus in, lorem.";
    }

    public static String sedUt() {
        return "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?";
    }

    public static String atVero() {
        return "At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.";
    }
    
    public static String loremIpsumParagraphs()
    {
        StringBuilder result = new StringBuilder();
        result.append( loremIpsum() );
        result.append( "\n\n" );
        result.append( sedUt() );
        result.append( "\n\n" );
        result.append( atVero() );
        
        return result.toString();
    }
    
    public static String jabberwockyQuote(){
        return "A nonsense poem written by Lewis Carroll about the killing of an animal called \"the Jabberwock\". It was included in his 1871 novel *Through the Looking-Glass, and What Alice Found There*, a sequel to *Alice's Adventures in Wonderland*. -Wikipedia";
    }
    
    public static String jabberwocky()
    {
        return "'Twas brillig, and the slithy toves" + "  \n"
               + "Did gyre and gimble in the wabe:" + "  \n"
               + "All mimsy were the borogoves," + "  \n"
               + "And the mome raths outgrabe." + "  \n"
               + "\n"
               + "\"Beware the Jabberwock, my son!" + "  \n"
               + "The jaws that bite, the claws that catch!" + "  \n"
               + "Beware the Jubjub bird, and shun" + "  \n"
               + "The frumious Bandersnatch!\"" + "  \n"
               + "He took his vorpal sword in hand:" + "  \n"
               + "Long time the manxome foe he sought --" + "  \n"
               + "So rested he by the Tumtum tree," + "  \n"
               + "And stood awhile in thought." + "  \n"
               + "And, as in uffish thought he stood," + "  \n"
               + "The Jabberwock, with eyes of flame," + "  \n"
               + "Came whiffling through the tulgey wood," + "  \n"
               + "And burbled as it came!" + "  \n"
               + "One, two! One, two! And through and through" + "  \n"
               + "The vorpal blade went snicker-snack!" + "  \n"
               + "He left it dead, and with its head" + "  \n"
               + "He went galumphing back." + "  \n"
               + "\"And, has thou slain the Jabberwock?" + "  \n"
               + "Come to my arms, my beamish boy!" + "  \n"
               + "O frabjous day! Callooh! Callay!'" + "  \n"
               + "He chortled in his joy." + "  \n"
               + "\n"
               + "'Twas brillig, and the slithy toves" + "  \n"
               + "Did gyre and gimble in the wabe;" + "  \n"
               + "All mimsy were the borogoves," + "  \n"
               + "And the mome raths outgrabe.";
    }
    
    public static String ravenQuote(){
        return "Edgar Allen Poe's classic tale of loss and horror.";
    }
    
    public static String raven()
    {
        return "Once upon a midnight dreary, while I pondered weak and weary," + "  \n"
               + "Over many a quaint and curious volume of forgotten lore," + "  \n"
               + "While I nodded, nearly napping, suddenly there came a tapping," + "  \n"
               + "As of some one gently rapping, rapping at my chamber door." + "  \n"
               + "''Tis some visitor,' I muttered, 'tapping at my chamber door -" + "  \n"
               + "Only this, and nothing more.'" + "\n"
               + "\n\n"
               + "Ah, distinctly I remember it was in the bleak December," + "  \n"
               + "And each separate dying ember wrought its ghost upon the floor." + "  \n"
               + "Eagerly I wished the morrow; - vainly I had sought to borrow" + "  \n"
               + "From my books surcease of sorrow - sorrow for the lost Lenore -" + "  \n"
               + "For the rare and radiant maiden whom the angels named Lenore -" + "  \n"
               + "Nameless here for evermore." + "\n"
               + "\n\n"
               + "And the silken sad uncertain rustling of each purple curtain" + "  \n"
               + "Thrilled me - filled me with fantastic terrors never felt before;" + "  \n"
               + "So that now, to still the beating of my heart, I stood repeating" + "  \n"
               + "''Tis some visitor entreating entrance at my chamber door -" + "  \n"
               + "Some late visitor entreating entrance at my chamber door; -" + "  \n"
               + "This it is, and nothing more,'" + "\n"
               + "\n\n"
               + "Presently my soul grew stronger; hesitating then no longer," + "  \n"
               + "'Sir,' said I, 'or Madam, truly your forgiveness I implore;" + "  \n"
               + "But the fact is I was napping, and so gently you came rapping," + "  \n"
               + "And so faintly you came tapping, tapping at my chamber door," + "  \n"
               + "That I scarce was sure I heard you' - here I opened wide the door; -" + "  \n"
               + "Darkness there, and nothing more." + "\n"
               + "\n\n"
               + "Deep into that darkness peering, long I stood there wondering, fearing," + "  \n"
               + "Doubting, dreaming dreams no mortal ever dared to dream before;" + "  \n"
               + "But the silence was unbroken, and the darkness gave no token," + "  \n"
               + "And the only word there spoken was the whispered word, 'Lenore!'" + "  \n"
               + "This I whispered, and an echo murmured back the word, 'Lenore!'" + "  \n"
               + "Merely this and nothing more." + "  \n"
               + "\n\n"
               + "Back into the chamber turning, all my soul within me burning," + "  \n"
               + "Soon again I heard a tapping somewhat louder than before." + "  \n"
               + "'Surely,' said I, 'surely that is something at my window lattice;" + "  \n"
               + "Let me see then, what thereat is, and this mystery explore -" + "  \n"
               + "Let my heart be still a moment and this mystery explore; -" + "  \n"
               + "'Tis the wind and nothing more!'" + "\n"
               + "\n\n"
               + "Open here I flung the shutter, when, with many a flirt and flutter," + "  \n"
               + "In there stepped a stately raven of the saintly days of yore." + "  \n"
               + "Not the least obeisance made he; not a minute stopped or stayed he;" + "  \n"
               + "But, with mien of lord or lady, perched above my chamber door -" + "  \n"
               + "Perched upon a bust of Pallas just above my chamber door -" + "  \n"
               + "Perched, and sat, and nothing more." + "\n"
               + "\n\n"
               + "Then this ebony bird beguiling my sad fancy into smiling," + "  \n"
               + "By the grave and stern decorum of the countenance it wore," + "  \n"
               + "'Though thy crest be shorn and shaven, thou,' I said, 'art sure no craven." + "  \n"
               + "Ghastly grim and ancient raven wandering from the nightly shore -" + "  \n"
               + "Tell me what thy lordly name is on the Night's Plutonian shore!'" + "  \n"
               + "Quoth the raven, 'Nevermore.'" + "\n"
               + "\n\n"
               + "Much I marvelled this ungainly fowl to hear discourse so plainly," + "  \n"
               + "Though its answer little meaning - little relevancy bore;" + "  \n"
               + "For we cannot help agreeing that no living human being" + "  \n"
               + "Ever yet was blessed with seeing bird above his chamber door -" + "  \n"
               + "Bird or beast above the sculptured bust above his chamber door," + "  \n"
               + "With such name as 'Nevermore.'" + "\n"
               + "\n\n"
               + "But the raven, sitting lonely on the placid bust, spoke only," + "  \n"
               + "That one word, as if his soul in that one word he did outpour." + "  \n"
               + "Nothing further then he uttered - not a feather then he fluttered -" + "  \n"
               + "Till I scarcely more than muttered 'Other friends have flown before -" + "  \n"
               + "On the morrow he will leave me, as my hopes have flown before.'" + "  \n"
               + "Then the bird said, 'Nevermore.'" + "\n"
               + "\n\n"
               + "Startled at the stillness broken by reply so aptly spoken," + "  \n"
               + "'Doubtless,' said I, 'what it utters is its only stock and store," + "  \n"
               + "Caught from some unhappy master whom unmerciful disaster" + "  \n"
               + "Followed fast and followed faster till his songs one burden bore -" + "  \n"
               + "Till the dirges of his hope that melancholy burden bore" + "  \n"
               + "Of \"Never-nevermore.\"'" + "\n"
               + "\n\n"
               + "But the raven still beguiling all my sad soul into smiling," + "  \n"
               + "Straight I wheeled a cushioned seat in front of bird and bust and door;" + "  \n"
               + "Then, upon the velvet sinking, I betook myself to linking" + "  \n"
               + "Fancy unto fancy, thinking what this ominous bird of yore -" + "  \n"
               + "What this grim, ungainly, ghastly, gaunt, and ominous bird of yore" + "  \n"
               + "Meant in croaking 'Nevermore.'" + "\n"
               + "\n\n"
               + "This I sat engaged in guessing, but no syllable expressing" + "  \n"
               + "To the fowl whose fiery eyes now burned into my bosom's core;" + "  \n"
               + "This and more I sat divining, with my head at ease reclining" + "  \n"
               + "On the cushion's velvet lining that the lamp-light gloated o'er," + "  \n"
               + "But whose velvet violet lining with the lamp-light gloating o'er," + "  \n"
               + "She shall press, ah, nevermore!" + "\n"
               + "\n\n"
               + "Then, methought, the air grew denser, perfumed from an unseen censer" + "  \n"
               + "Swung by Seraphim whose foot-falls tinkled on the tufted floor." + "  \n"
               + "'Wretch,' I cried, 'thy God hath lent thee - by these angels he has sent thee" + "  \n"
               + "Respite - respite and nepenthe from thy memories of Lenore!" + "  \n"
               + "Quaff, oh quaff this kind nepenthe, and forget this lost Lenore!'" + "  \n"
               + "Quoth the raven, 'Nevermore.'" + "\n"
               + "\n\n"
               + "'Prophet!' said I, 'thing of evil! - prophet still, if bird or devil! -" + "  \n"
               + "Whether tempter sent, or whether tempest tossed thee here ashore," + "  \n"
               + "Desolate yet all undaunted, on this desert land enchanted -" +   "\n"
               + "On this home by horror haunted - tell me truly, I implore -" + "  \n"
               + "Is there - is there balm in Gilead? - tell me - tell me, I implore!'" + "  \n"
               + "Quoth the raven, 'Nevermore.'" + "\n"
               + "\n\n"
               + "'Prophet!' said I, 'thing of evil! - prophet still, if bird or devil!" + "  \n"
               + "By that Heaven that bends above us - by that God we both adore -" + "  \n"
               + "Tell this soul with sorrow laden if, within the distant Aidenn," + "  \n"
               + "It shall clasp a sainted maiden whom the angels named Lenore -" + "  \n"
               + "Clasp a rare and radiant maiden, whom the angels named Lenore?'" + "  \n"
               + "Quoth the raven, 'Nevermore.'" + "\n"
               + "\n\n"
               + "'Be that word our sign of parting, bird or fiend!' I shrieked upstarting -" + "  \n"
               + "'Get thee back into the tempest and the Night's Plutonian shore!" + "  \n"
               + "Leave no black plume as a token of that lie thy soul hath spoken!" + "  \n"
               + "Leave my loneliness unbroken! - quit the bust above my door!" + "  \n"
               + "Take thy beak from out my heart, and take thy form from off my door!'" + "  \n"
               + "Quoth the raven, 'Nevermore.'" + "\n"
               + "\n\n"
               + "And the raven, never flitting, still is sitting, still is sitting" + "  \n"
               + "On the pallid bust of Pallas just above my chamber door;" + "  \n"
               + "And his eyes have all the seeming of a demon's that is dreaming," + "  \n"
               + "And the lamp-light o'er him streaming throws his shadow on the floor;" + "  \n"
               + "And my soul from out that shadow that lies floating on the floor" + "  \n"
               + "Shall be lifted - nevermore!";

    }
}
