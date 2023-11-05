package data_models

import android.os.Parcel
import android.os.Parcelable

data class AnimalDetails(val animalName: String, val animalDesc: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(animalName)
        parcel.writeString(animalDesc)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AnimalDetails> {
        private val animalList = mutableListOf(
            AnimalDetails("Axolotl", "Known as the Mexican walking fish, the Axolotl is a unique aquatic salamander native to Mexico. It possesses remarkable regenerative abilities, retaining its juvenile features throughout its life, and is characterized by its external gills, fringed with feathery structures, giving it a captivating appearance in both aquatic and terrestrial environments."),
            AnimalDetails("Bison", "Known as buffalo, Bisons are large, herbivorous mammals native to North America. They have a distinctive hump on their back and are known for their strength and resilience."),
            AnimalDetails("Cheetah", "Known as the fastest land animal, Cheetahs are capable of reaching speeds up to 70 miles per hour. They are slender, agile big cats, known for their distinctive black spots and tear markings on their faces."),
            AnimalDetails("Dolphin", "Highly intelligent marine mammals known for their playful behavior and remarkable communication skills, Dolphins are characterized by their streamlined bodies and curved dorsal fins."),
            AnimalDetails("Elephant", "Elephants, the largest land animals, are highly intelligent and social creatures, living in close-knit family groups in the wild."),
            AnimalDetails("Flamingo", "Tall, wading birds with distinctive pink plumage and long, slender legs, Flamingos are often found in large flocks near shallow lakes and lagoons, using their unique beaks to filter feed on small aquatic organisms."),
            AnimalDetails("Giraffe", "Giraffes, the world's tallest land animals, are known for their long necks and distinctive spotted patterns on their bodies. They feed on leaves and buds high in trees using their prehensile tongues."),
            AnimalDetails("Hedgehog", "Hedgehogs are small spiny mammals that roll into a ball as a defense mechanism. They are nocturnal creatures and primarily insectivores, feeding on insects, snails, and other small invertebrates."),
            AnimalDetails("Iguana", "Iguanas are reptiles native to Central and South America, known for their long tails, spiky crests, and excellent climbing abilities. They are herbivorous and primarily feed on leaves, fruits, and flowers."),
            AnimalDetails("Jaguar", "Large, powerful big cats native to the Americas, Jaguars have a distinctive golden-yellow coat with dark spots and rosettes. Jaguars are skilled hunters and are known for their strength and agility."),
            AnimalDetails("Kangaroo", "Kangaroos are marsupials found in Australia, known for their powerful hind legs and tail, which they use for hopping. They carry and nurse their underdeveloped young, called joeys, in a pouch on their abdomen."),
            AnimalDetails("Lion", "Lions are iconic big cats known for their majestic manes and social behavior. They live in prides, with females doing most of the hunting. Lions are apex predators and play a crucial role in maintaining the balance of their ecosystems."),
            AnimalDetails("Manatee", "Manatees, often referred to as a sea cow, are herbivorous aquatic mammal found in warm, shallow waters along the coasts and rivers of the Americas, Africa, and Australia. Known for their gentle nature, manatees are slow-moving creatures with thick, wrinkled skin and paddle-like flippers, primarily feeding on aquatic plants and sea grasses."),
            AnimalDetails("Nightingale", "Nightingales are small, highly vocal birds known for their melodious songs, often associated with the arrival of spring. They have brown plumage and are known for their powerful and beautiful vocalizations, often sung during the night."),
            AnimalDetails("Ostrich", "Ostriches are flightless birds native to Africa, known for their large size and long necks. They are the largest and heaviest living bird species, with powerful legs that enable them to run at high speeds."),
            AnimalDetails("Penguin", "Penguins are aquatic, flightless birds found in the Southern Hemisphere. They are excellent swimmers and are well adapted to their aquatic life, with waterproof feathers and flipper-like wings. Penguins often live in large colonies and are skilled hunters in the water."),
            AnimalDetails("Quokka", "Quokkas are small marsupials native to Australia, known for their friendly and smiling facial expressions. They are herbivorous and primarily feed on plants, leaves, and small shrubs, and are often referred to as the \"world's happiest animal.\""),
            AnimalDetails("Raccoon", "Raccoons are omnivorous mammals native to North America, known for their distinctive black mask-like markings around their eyes. They are highly adaptable and intelligent animals, often found in urban areas rummaging through garbage cans for food."),
            AnimalDetails("Sloth", "Sloths are slow-moving mammals found in Central and South America. They are arboreal creatures, spending most of their time hanging upside down from trees. Sloths have a slow metabolism and primarily feed on leaves and buds."),
            AnimalDetails("Tiger", "Tigers are large, powerful big cats known for their striking orange coat with black stripes. They are apex predators and are skilled hunters, capable of taking down large prey. Tigers are critically endangered, with conservation efforts in place to protect their populations."),
            AnimalDetails("Uakari", "Uakaris are primates native to South America, recognized for their bald heads and bright red faces. They primarily inhabit flooded rainforests and are herbivorous, feeding on fruits, seeds, and leaves."),
            AnimalDetails("Vulture", "Vultures are scavenging birds of prey known for their keen eyesight and powerful beaks. They play a crucial role in ecosystems by feeding on carrion, helping to clean up the environment and prevent the spread of diseases."),
            AnimalDetails("Wombat", "Wombats are burrowing marsupials native to Australia. They have a sturdy build and are well adapted for digging. Wombats are herbivorous, feeding on grasses, roots, and bark, and they are known for their cube-shaped feces."),
            AnimalDetails("X-ray Tetra", "The X-ray tetra is a small, transparent fish found in the Amazon Basin. Its name comes from its translucent body, allowing its internal organs to be visible, resembling an X-ray image. They are popular aquarium fish due to their unique appearance."),
            AnimalDetails("Yak", "The yak is a sturdy, long-haired mammal native to the mountainous regions of Central Asia. Renowned for its thick fur, humped back, and curved horns, yaks are well-adapted to harsh cold climates, serving as essential livestock for the local communities by providing milk, meat, fur, and transportation in rugged terrains."),
            AnimalDetails("Zebra", "Zebras are large herbivorous mammals native to Africa, known for their black and white striped coat. Each zebra has a unique stripe pattern, and they are social animals often found in groups, grazing in the savannas. Zebras use their stripes as a form of camouflage and for social recognition within their herds.")
        )

        fun getAnimalList(): List<AnimalDetails> {
            return animalList.toList() //converts objects into list
        }

        override fun createFromParcel(parcel: Parcel): AnimalDetails {
            return AnimalDetails(parcel)
        }

        override fun newArray(size: Int): Array<AnimalDetails?> {
            return arrayOfNulls(size)
        }
    }
}

