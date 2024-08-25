package com.example.demo.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.MascotaRepository;

import jakarta.transaction.Transactional;

@Controller
@Transactional
public class DatabaseInit implements ApplicationRunner{
    @Autowired 
    AdminRepository adminRepository;
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    MascotaRepository mascotaRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception{
        //Creación administrador
        adminRepository.save(new Admin("admin","admin"));
        //Creación clientes
        clienteRepository.save(new Cliente(1235062800,"Dylan Richardson","facilisis.vitae@aol.org",309878724L));
        clienteRepository.save(new Cliente(1640900910,"Ignatius Compton","quis@yahoo.org",362491489L));
        clienteRepository.save(new Cliente(1678516338,"Ulric Wyatt","nam.nulla@icloud.ca",343261472L));
        clienteRepository.save(new Cliente(1036204790,"Fatima Duke","in.magna.phasellus@icloud.edu",352605555L));
        clienteRepository.save(new Cliente(1189595192,"Ramona Grant","vivamus.nibh.dolor@protonmail.ca",327982210L));
        clienteRepository.save(new Cliente(1183244032,"Kasper Riggs","sit.amet@outlook.edu",397804552L));
        clienteRepository.save(new Cliente(1397485934,"Maya Mckee","mi.pede@aol.couk",399530581L));
        clienteRepository.save(new Cliente(1620457771,"Walter O'brien","vel.est@icloud.ca",390253335L));
        clienteRepository.save(new Cliente(1582417121,"Kaseem Martinez","mattis.semper.dui@google.org",392755622L));
        clienteRepository.save(new Cliente(1034035854,"Uriah Summers","felis.ullamcorper@aol.ca",369992569L));
        clienteRepository.save(new Cliente(1466299629,"Murphy Shepard","maecenas.iaculis@aol.org",313644622L));
        clienteRepository.save(new Cliente(1784649564,"Nomlanga Montoya","lacus.nulla@hotmail.couk",370883016L));
        clienteRepository.save(new Cliente(1463685994,"Nyssa Stark","donec@protonmail.net",383581138L));
        clienteRepository.save(new Cliente(1399417492,"Cara Haynes","massa@yahoo.ca",320735830L));
        clienteRepository.save(new Cliente(1508218624,"Kenyon Atkins","cubilia.curae@google.net",305385837L));
        clienteRepository.save(new Cliente(1261477208,"Brianna Mercer","vulputate.lacus.cras@protonmail.com",336919594L));
        clienteRepository.save(new Cliente(1798229791,"Grace O'connor","et.nunc.quisque@protonmail.com",341209077L));
        clienteRepository.save(new Cliente(1960954227,"Jackson Burke","in@yahoo.ca",373618151L));
        clienteRepository.save(new Cliente(1122533361,"Lee Sherman","dictum.augue.malesuada@protonmail.net",353010632L));
        clienteRepository.save(new Cliente(1823569570,"Stone Head","semper@icloud.org",350562141L));
        clienteRepository.save(new Cliente(1455442208,"Lydia Garza","sit@outlook.net",311661409L));
        clienteRepository.save(new Cliente(1572945473,"Grady Kemp","nibh.dolor@yahoo.org",354768717L));
        clienteRepository.save(new Cliente(1595362487,"Hu Blevins","ultrices@outlook.org",320992125L));
        clienteRepository.save(new Cliente(1331569072,"Tiger Hardin","pellentesque.massa.lobortis@outlook.couk",341722894L));
        clienteRepository.save(new Cliente(1708960240,"Caryn Sampson","lorem.tristique@protonmail.edu",389899935L));
        clienteRepository.save(new Cliente(1598085497,"Zane Moreno","enim.sit.amet@google.couk",303549176L));
        clienteRepository.save(new Cliente(1753745354,"Abel Maldonado","eu.ultrices.sit@yahoo.edu",380912685L));
        clienteRepository.save(new Cliente(1579299760,"Cole Sanders","aliquam@icloud.edu",367149685L));
        clienteRepository.save(new Cliente(1463387523,"Philip Whitney","quisque@aol.ca",388499798L));
        clienteRepository.save(new Cliente(1050178599,"Hayden Park","neque@yahoo.edu",323061512L));
        clienteRepository.save(new Cliente(1307382282,"Gary Hines","tempus.scelerisque@google.net",385102160L));
        clienteRepository.save(new Cliente(1741434712,"Jarrod Evans","euismod@outlook.couk",344535101L));
        clienteRepository.save(new Cliente(1524791740,"Walter Kirby","erat.in@aol.net",354068407L));
        clienteRepository.save(new Cliente(1880385151,"Jillian Turner","cras.lorem.lorem@hotmail.edu",348773599L));
        clienteRepository.save(new Cliente(1160176480,"Duncan Mcconnell","eu@outlook.ca",325270189L));
        clienteRepository.save(new Cliente(1072306213,"Ann Head","blandit.nam@aol.couk",349087931L));
        clienteRepository.save(new Cliente(1501134030,"Victoria Reynolds","tempor.diam@google.ca",376534512L));
        clienteRepository.save(new Cliente(1207377727,"Bert West","erat@google.ca",372549668L));
        clienteRepository.save(new Cliente(1460926052,"Celeste Clark","lacus.cras@google.net",364496843L));
        clienteRepository.save(new Cliente(1159817334,"Abel Avila","egestas@protonmail.couk",324290880L));
        clienteRepository.save(new Cliente(1807007174,"Tarik Glenn","tempor.diam@icloud.couk",342726857L));
        clienteRepository.save(new Cliente(1978101413,"Jolie Curtis","ultricies.dignissim@google.ca",358103227L));
        clienteRepository.save(new Cliente(1424794913,"Mira Wyatt","urna.nullam@aol.ca",384779144L));
        clienteRepository.save(new Cliente(1608244321,"Alec Maldonado","ultrices@protonmail.net",304733602L));
        clienteRepository.save(new Cliente(1010231564,"Brett Kirby","elementum@aol.org",399341081L));
        clienteRepository.save(new Cliente(1971408607,"Harrison Moreno","in.lobortis@protonmail.couk",336215273L));
        clienteRepository.save(new Cliente(1963427700,"Dora Shields","id@protonmail.com",376298968L));
        clienteRepository.save(new Cliente(1873486866,"Lareina Roy","velit.dui.semper@outlook.org",341482251L));
        clienteRepository.save(new Cliente(1410113199,"Drake Glenn","in.at@icloud.ca",333104316L));
        clienteRepository.save(new Cliente(1430947461,"Rebecca Adkins","malesuada.augue@icloud.edu",357772405L));
        //Creación mascotas
        mascotaRepository.save(new Mascota("Toby","Husky",2,24.0F,"Insuficiencia","https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Siberian-husky.jpg/480px-Siberian-husky.jpg",true,clienteRepository.findById(1235062800L).get()));
        mascotaRepository.save(new Mascota("Toby","Husky",2,24.0F,"Insuficiencia","https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Siberian-husky.jpg/480px-Siberian-husky.jpg",true,clienteRepository.findById(1235062800L).get()));
        mascotaRepository.save(new Mascota("Pepper","Husky",2,12.0F,"Parvovirus","https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Siberian-husky.jpg/480px-Siberian-husky.jpg",true,clienteRepository.findById(1640900910L).get()));
        mascotaRepository.save(new Mascota("Luna","Poodle",5,26.0F,"Traqueobronquitis","https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/Agility_Poodle.jpg/375px-Agility_Poodle.jpg",false,clienteRepository.findById(1678516338L).get()));
        mascotaRepository.save(new Mascota("Lucky","Golden",5,27.0F,"Dermatitis","https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Golden_retriever%2C_Argentina.jpg/330px-Golden_retriever%2C_Argentina.jpg",false,clienteRepository.findById(1036204790L).get()));
        mascotaRepository.save(new Mascota("Smokey","Golden",3,1.0F,"Cáncer","https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Golden_retriever%2C_Argentina.jpg/330px-Golden_retriever%2C_Argentina.jpg",false,clienteRepository.findById(1189595192L).get()));
        mascotaRepository.save(new Mascota("Harley","CockerSpaniel",4,3.0F,"Epilepsia","https://upload.wikimedia.org/wikipedia/commons/thumb/0/03/Cocker_spaniel_called_Tony.jpg/300px-Cocker_spaniel_called_Tony.jpg",true,clienteRepository.findById(1183244032L).get()));
        mascotaRepository.save(new Mascota("Lucy","Bulldog",14,10.0F,"Dirofilariasis","https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Racib%C3%B3rz_2007_082.jpg/480px-Racib%C3%B3rz_2007_082.jpg",false,clienteRepository.findById(1397485934L).get()));
        mascotaRepository.save(new Mascota("Poppy","Dachshund",9,9.0F,"Pancreatitis","https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Dachshund_brown_puppy.jpg/330px-Dachshund_brown_puppy.jpg",false,clienteRepository.findById(1620457771L).get()));
        mascotaRepository.save(new Mascota("Bella","Rottweiler",5,16.0F,"Cáncer","https://upload.wikimedia.org/wikipedia/commons/thumb/0/04/Rottweiler_kopf_2.jpg/549px-Rottweiler_kopf_2.jpg",true,clienteRepository.findById(1582417121L).get()));
        mascotaRepository.save(new Mascota("Penny","Husky",2,13.0F,"Hipotiroidismo","https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Siberian-husky.jpg/480px-Siberian-husky.jpg",true,clienteRepository.findById(1034035854L).get()));
        mascotaRepository.save(new Mascota("Sam","Pastor",14,26.0F,"Traqueobronquitis","https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Pastor_Alem%C3%A1n_hembra%2C_diez_a%C3%B1os_de_edad.jpg/330px-Pastor_Alem%C3%A1n_hembra%2C_diez_a%C3%B1os_de_edad.jpg",true,clienteRepository.findById(1466299629L).get()));
        mascotaRepository.save(new Mascota("Winston","Bulldog",12,18.0F,"Dermatitis","https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Racib%C3%B3rz_2007_082.jpg/480px-Racib%C3%B3rz_2007_082.jpg",false,clienteRepository.findById(1784649564L).get()));
        mascotaRepository.save(new Mascota("Maya","Poodle",8,7.0F,"Dirofilariasis","https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/Agility_Poodle.jpg/375px-Agility_Poodle.jpg",true,clienteRepository.findById(1463685994L).get()));
        mascotaRepository.save(new Mascota("Misty","Dachshund",20,24.0F,"Dirofilariasis","https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Dachshund_brown_puppy.jpg/330px-Dachshund_brown_puppy.jpg",true,clienteRepository.findById(1399417492L).get()));
        mascotaRepository.save(new Mascota("Oreo","BordeCollie",4,3.0F,"Traqueobronquitis","https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Border_collie_canon.jpg/480px-Border_collie_canon.jpg",false,clienteRepository.findById(1508218624L).get()));
        mascotaRepository.save(new Mascota("Gizmo","Husky",0,23.0F,"Leptospirosis","https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Siberian-husky.jpg/480px-Siberian-husky.jpg",true,clienteRepository.findById(1261477208L).get()));
        mascotaRepository.save(new Mascota("Oliver","Rottweiler",3,12.0F,"Traqueobronquitis","https://upload.wikimedia.org/wikipedia/commons/thumb/0/04/Rottweiler_kopf_2.jpg/549px-Rottweiler_kopf_2.jpg",true,clienteRepository.findById(1798229791L).get()));
        mascotaRepository.save(new Mascota("Bruno","Doberman",13,8.0F,"Epilepsia","https://upload.wikimedia.org/wikipedia/commons/thumb/6/6a/Jean_Dark_Sn%C3%B6_of_Sweden.jpg/330px-Jean_Dark_Sn%C3%B6_of_Sweden.jpg",false,clienteRepository.findById(1960954227L).get()));
        mascotaRepository.save(new Mascota("Penny","Boxer",4,22.0F,"Parvovirus","https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/HYPSO.JPG/169px-HYPSO.JPG",false,clienteRepository.findById(1122533361L).get()));
        mascotaRepository.save(new Mascota("Rosie","Pastor",19,19.0F,"Parvovirus","https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Pastor_Alem%C3%A1n_hembra%2C_diez_a%C3%B1os_de_edad.jpg/330px-Pastor_Alem%C3%A1n_hembra%2C_diez_a%C3%B1os_de_edad.jpg",false,clienteRepository.findById(1823569570L).get()));
        mascotaRepository.save(new Mascota("Oliver","Dachshund",0,3.0F,"Traqueobronquitis","https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Dachshund_brown_puppy.jpg/330px-Dachshund_brown_puppy.jpg",false,clienteRepository.findById(1455442208L).get()));
        mascotaRepository.save(new Mascota("Rocco","Yorkshire",1,18.0F,"Lyme","https://upload.wikimedia.org/wikipedia/commons/a/ab/Lola%2C_Yorkshire_Terrier_de_treinta_meses.jpg",false,clienteRepository.findById(1572945473L).get()));
        mascotaRepository.save(new Mascota("Thor","Rottweiler",3,27.0F,"Leptospirosis","https://upload.wikimedia.org/wikipedia/commons/thumb/0/04/Rottweiler_kopf_2.jpg/549px-Rottweiler_kopf_2.jpg",false,clienteRepository.findById(1595362487L).get()));
        mascotaRepository.save(new Mascota("Oscar","Husky",13,1.0F,"Rabia","https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Siberian-husky.jpg/480px-Siberian-husky.jpg",false,clienteRepository.findById(1331569072L).get()));
        mascotaRepository.save(new Mascota("Duke","Boxer",12,6.0F,"Insuficiencia","https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/HYPSO.JPG/169px-HYPSO.JPG",false,clienteRepository.findById(1708960240L).get()));
        mascotaRepository.save(new Mascota("Hunter","Poodle",3,18.0F,"Insuficiencia","https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/Agility_Poodle.jpg/375px-Agility_Poodle.jpg",false,clienteRepository.findById(1598085497L).get()));
        mascotaRepository.save(new Mascota("Zeus","Dachshund",7,7.0F,"Dermatitis","https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Dachshund_brown_puppy.jpg/330px-Dachshund_brown_puppy.jpg",true,clienteRepository.findById(1753745354L).get()));
        mascotaRepository.save(new Mascota("Leo","Bulldog",9,24.0F,"Rabia","https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Racib%C3%B3rz_2007_082.jpg/480px-Racib%C3%B3rz_2007_082.jpg",false,clienteRepository.findById(1579299760L).get()));
        mascotaRepository.save(new Mascota("Bandit","Yorkshire",10,8.0F,"Dermatitis","https://upload.wikimedia.org/wikipedia/commons/a/ab/Lola%2C_Yorkshire_Terrier_de_treinta_meses.jpg",true,clienteRepository.findById(1463387523L).get()));
        mascotaRepository.save(new Mascota("Nala","Poodle",13,2.0F,"Epilepsia","https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/Agility_Poodle.jpg/375px-Agility_Poodle.jpg",false,clienteRepository.findById(1050178599L).get()));
        mascotaRepository.save(new Mascota("Lucky","Husky",1,12.0F,"Dirofilariasis","https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Siberian-husky.jpg/480px-Siberian-husky.jpg",false,clienteRepository.findById(1307382282L).get()));
        mascotaRepository.save(new Mascota("Willow","Bulldog",19,8.0F,"Insuficiencia","https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Racib%C3%B3rz_2007_082.jpg/480px-Racib%C3%B3rz_2007_082.jpg",false,clienteRepository.findById(1741434712L).get()));
        mascotaRepository.save(new Mascota("Maya","Dachshund",0,1.0F,"Displasia","https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Dachshund_brown_puppy.jpg/330px-Dachshund_brown_puppy.jpg",true,clienteRepository.findById(1524791740L).get()));
        mascotaRepository.save(new Mascota("Nala","Poodle",12,28.0F,"Moquillo","https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/Agility_Poodle.jpg/375px-Agility_Poodle.jpg",false,clienteRepository.findById(1880385151L).get()));
        mascotaRepository.save(new Mascota("Cupcake","Bulldog",13,4.0F,"Periodontal","https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Racib%C3%B3rz_2007_082.jpg/480px-Racib%C3%B3rz_2007_082.jpg",true,clienteRepository.findById(1160176480L).get()));
        mascotaRepository.save(new Mascota("Rocky","Pug",7,24.0F,"Displasia","https://upload.wikimedia.org/wikipedia/commons/thumb/6/63/Mops-falk-vom-maegdebrunnen-internationaler-champion-fci.jpg/330px-Mops-falk-vom-maegdebrunnen-internationaler-champion-fci.jpg",false,clienteRepository.findById(1072306213L).get()));
        mascotaRepository.save(new Mascota("Mabel","Chihuahua",13,2.0F,"Sarna","https://upload.wikimedia.org/wikipedia/commons/thumb/4/4c/Chihuahua1_bvdb.jpg/330px-Chihuahua1_bvdb.jpg",true,clienteRepository.findById(1501134030L).get()));
        mascotaRepository.save(new Mascota("Ivy","Dachshund",11,18.0F,"Displasia","https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Dachshund_brown_puppy.jpg/330px-Dachshund_brown_puppy.jpg",true,clienteRepository.findById(1207377727L).get()));
        mascotaRepository.save(new Mascota("Spike","Doberman",6,15.0F,"Dirofilariasis","https://upload.wikimedia.org/wikipedia/commons/thumb/6/6a/Jean_Dark_Sn%C3%B6_of_Sweden.jpg/330px-Jean_Dark_Sn%C3%B6_of_Sweden.jpg",true,clienteRepository.findById(1460926052L).get()));
        mascotaRepository.save(new Mascota("Niko","Boxer",9,17.0F,"Obesidad","https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/HYPSO.JPG/169px-HYPSO.JPG",true,clienteRepository.findById(1159817334L).get()));
        mascotaRepository.save(new Mascota("Firulais","Labrador",1,12.0F,"Cáncer","https://upload.wikimedia.org/wikipedia/commons/thumb/0/04/Labrador_Retriever_%281210559%29.jpg/480px-Labrador_Retriever_%281210559%29.jpg",false,clienteRepository.findById(1807007174L).get()));
        mascotaRepository.save(new Mascota("Teddy","Doberman",5,26.0F,"Obesidad","https://upload.wikimedia.org/wikipedia/commons/thumb/6/6a/Jean_Dark_Sn%C3%B6_of_Sweden.jpg/330px-Jean_Dark_Sn%C3%B6_of_Sweden.jpg",true,clienteRepository.findById(1978101413L).get()));
        mascotaRepository.save(new Mascota("Rex","CockerSpaniel",12,26.0F,"Sarna","https://upload.wikimedia.org/wikipedia/commons/thumb/0/03/Cocker_spaniel_called_Tony.jpg/300px-Cocker_spaniel_called_Tony.jpg",false,clienteRepository.findById(1424794913L).get()));
        mascotaRepository.save(new Mascota("Angel","Boxer",19,24.0F,"Lyme","https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/HYPSO.JPG/169px-HYPSO.JPG",true,clienteRepository.findById(1608244321L).get()));
        mascotaRepository.save(new Mascota("Penny","Dachshund",18,2.0F,"Moquillo","https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Dachshund_brown_puppy.jpg/330px-Dachshund_brown_puppy.jpg",false,clienteRepository.findById(1010231564L).get()));
        mascotaRepository.save(new Mascota("Bandit","Yorkshire",5,8.0F,"Displasia","https://upload.wikimedia.org/wikipedia/commons/a/ab/Lola%2C_Yorkshire_Terrier_de_treinta_meses.jpg",false,clienteRepository.findById(1971408607L).get()));
        mascotaRepository.save(new Mascota("Niko","Rottweiler",4,7.0F,"Insuficiencia","https://upload.wikimedia.org/wikipedia/commons/thumb/0/04/Rottweiler_kopf_2.jpg/549px-Rottweiler_kopf_2.jpg",true,clienteRepository.findById(1963427700L).get()));
        mascotaRepository.save(new Mascota("Toby","Beagle",17,5.0F,"Hipotiroidismo","https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Shemsu_Sotis_Perun.jpg/480px-Shemsu_Sotis_Perun.jpg",false,clienteRepository.findById(1873486866L).get()));
        mascotaRepository.save(new Mascota("Lucky","Husky",7,3.0F,"Cáncer","https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Siberian-husky.jpg/480px-Siberian-husky.jpg",true,clienteRepository.findById(1410113199L).get()));
        mascotaRepository.save(new Mascota("Chloe","BordeCollie",10,9.0F,"Obesidad","https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Border_collie_canon.jpg/480px-Border_collie_canon.jpg",true,clienteRepository.findById(1430947461L).get()));
        mascotaRepository.save(new Mascota("Mabel","Husky",19,17.0F,"Obesidad","https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Siberian-husky.jpg/480px-Siberian-husky.jpg",true,clienteRepository.findById(1235062800L).get()));
        mascotaRepository.save(new Mascota("Leo","Boxer",17,10.0F,"Sarna","https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/HYPSO.JPG/169px-HYPSO.JPG",false,clienteRepository.findById(1640900910L).get()));
        mascotaRepository.save(new Mascota("Sasha","Chihuahua",14,11.0F,"Lyme","https://upload.wikimedia.org/wikipedia/commons/thumb/4/4c/Chihuahua1_bvdb.jpg/330px-Chihuahua1_bvdb.jpg",true,clienteRepository.findById(1678516338L).get()));
        mascotaRepository.save(new Mascota("Ace","Yorkshire",5,5.0F,"Lyme","https://upload.wikimedia.org/wikipedia/commons/a/ab/Lola%2C_Yorkshire_Terrier_de_treinta_meses.jpg",true,clienteRepository.findById(1036204790L).get()));
        mascotaRepository.save(new Mascota("Jasper","Pug",6,14.0F,"Dirofilariasis","https://upload.wikimedia.org/wikipedia/commons/thumb/6/63/Mops-falk-vom-maegdebrunnen-internationaler-champion-fci.jpg/330px-Mops-falk-vom-maegdebrunnen-internationaler-champion-fci.jpg",false,clienteRepository.findById(1189595192L).get()));
        mascotaRepository.save(new Mascota("Ruby","Doberman",4,6.0F,"Hipotiroidismo","https://upload.wikimedia.org/wikipedia/commons/thumb/6/6a/Jean_Dark_Sn%C3%B6_of_Sweden.jpg/330px-Jean_Dark_Sn%C3%B6_of_Sweden.jpg",false,clienteRepository.findById(1183244032L).get()));
        mascotaRepository.save(new Mascota("Hunter","Dachshund",11,5.0F,"Insuficiencia","https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Dachshund_brown_puppy.jpg/330px-Dachshund_brown_puppy.jpg",true,clienteRepository.findById(1397485934L).get()));
        mascotaRepository.save(new Mascota("Oliver","Dachshund",14,23.0F,"Leptospirosis","https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Dachshund_brown_puppy.jpg/330px-Dachshund_brown_puppy.jpg",true,clienteRepository.findById(1620457771L).get()));
        mascotaRepository.save(new Mascota("Loki","Pug",20,15.0F,"Leptospirosis","https://upload.wikimedia.org/wikipedia/commons/thumb/6/63/Mops-falk-vom-maegdebrunnen-internationaler-champion-fci.jpg/330px-Mops-falk-vom-maegdebrunnen-internationaler-champion-fci.jpg",true,clienteRepository.findById(1582417121L).get()));
        mascotaRepository.save(new Mascota("Lily","Pastor",8,16.0F,"Insuficiencia","https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Pastor_Alem%C3%A1n_hembra%2C_diez_a%C3%B1os_de_edad.jpg/330px-Pastor_Alem%C3%A1n_hembra%2C_diez_a%C3%B1os_de_edad.jpg",false,clienteRepository.findById(1034035854L).get()));
        mascotaRepository.save(new Mascota("Muffin","Beagle",13,16.0F,"Hipotiroidismo","https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Shemsu_Sotis_Perun.jpg/480px-Shemsu_Sotis_Perun.jpg",false,clienteRepository.findById(1466299629L).get()));
        mascotaRepository.save(new Mascota("Toby","Bulldog",1,25.0F,"Otitis","https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Racib%C3%B3rz_2007_082.jpg/480px-Racib%C3%B3rz_2007_082.jpg",false,clienteRepository.findById(1784649564L).get()));
        mascotaRepository.save(new Mascota("Poppy","Pastor",1,11.0F,"Cáncer","https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Pastor_Alem%C3%A1n_hembra%2C_diez_a%C3%B1os_de_edad.jpg/330px-Pastor_Alem%C3%A1n_hembra%2C_diez_a%C3%B1os_de_edad.jpg",false,clienteRepository.findById(1463685994L).get()));
        mascotaRepository.save(new Mascota("Maya","Golden",14,8.0F,"Traqueobronquitis","https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Golden_retriever%2C_Argentina.jpg/330px-Golden_retriever%2C_Argentina.jpg",true,clienteRepository.findById(1399417492L).get()));
        mascotaRepository.save(new Mascota("Jake","Dachshund",15,1.0F,"Dermatitis","https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Dachshund_brown_puppy.jpg/330px-Dachshund_brown_puppy.jpg",false,clienteRepository.findById(1508218624L).get()));
        mascotaRepository.save(new Mascota("Mabel","Yorkshire",6,29.0F,"Moquillo","https://upload.wikimedia.org/wikipedia/commons/a/ab/Lola%2C_Yorkshire_Terrier_de_treinta_meses.jpg",false,clienteRepository.findById(1261477208L).get()));
        mascotaRepository.save(new Mascota("Ziggy","Labrador",11,12.0F,"Pancreatitis","https://upload.wikimedia.org/wikipedia/commons/thumb/0/04/Labrador_Retriever_%281210559%29.jpg/480px-Labrador_Retriever_%281210559%29.jpg",false,clienteRepository.findById(1798229791L).get()));
        mascotaRepository.save(new Mascota("Bruno","Dachshund",5,18.0F,"Artritis","https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Dachshund_brown_puppy.jpg/330px-Dachshund_brown_puppy.jpg",true,clienteRepository.findById(1960954227L).get()));
        mascotaRepository.save(new Mascota("Rex","Pug",1,26.0F,"Otitis","https://upload.wikimedia.org/wikipedia/commons/thumb/6/63/Mops-falk-vom-maegdebrunnen-internationaler-champion-fci.jpg/330px-Mops-falk-vom-maegdebrunnen-internationaler-champion-fci.jpg",false,clienteRepository.findById(1122533361L).get()));
        mascotaRepository.save(new Mascota("Lucky","Beagle",12,10.0F,"Cáncer","https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Shemsu_Sotis_Perun.jpg/480px-Shemsu_Sotis_Perun.jpg",true,clienteRepository.findById(1823569570L).get()));
        mascotaRepository.save(new Mascota("Daisy","Beagle",11,4.0F,"Cáncer","https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Shemsu_Sotis_Perun.jpg/480px-Shemsu_Sotis_Perun.jpg",false,clienteRepository.findById(1455442208L).get()));
        mascotaRepository.save(new Mascota("Winston","Golden",17,23.0F,"Rabia","https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Golden_retriever%2C_Argentina.jpg/330px-Golden_retriever%2C_Argentina.jpg",false,clienteRepository.findById(1572945473L).get()));
        mascotaRepository.save(new Mascota("Jack","Yorkshire",9,24.0F,"Cáncer","https://upload.wikimedia.org/wikipedia/commons/a/ab/Lola%2C_Yorkshire_Terrier_de_treinta_meses.jpg",false,clienteRepository.findById(1595362487L).get()));
        mascotaRepository.save(new Mascota("Ruby","Golden",14,6.0F,"Obesidad","https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Golden_retriever%2C_Argentina.jpg/330px-Golden_retriever%2C_Argentina.jpg",true,clienteRepository.findById(1331569072L).get()));
        mascotaRepository.save(new Mascota("Poppy","Chihuahua",4,21.0F,"Periodontal","https://upload.wikimedia.org/wikipedia/commons/thumb/4/4c/Chihuahua1_bvdb.jpg/330px-Chihuahua1_bvdb.jpg",false,clienteRepository.findById(1708960240L).get()));
        mascotaRepository.save(new Mascota("Midnight","CockerSpaniel",5,12.0F,"Traqueobronquitis","Foto",true,clienteRepository.findById(1598085497L).get()));
        mascotaRepository.save(new Mascota("Rex","Pastor",3,22.0F,"Lyme","https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Pastor_Alem%C3%A1n_hembra%2C_diez_a%C3%B1os_de_edad.jpg/330px-Pastor_Alem%C3%A1n_hembra%2C_diez_a%C3%B1os_de_edad.jpg",false,clienteRepository.findById(1753745354L).get()));
        mascotaRepository.save(new Mascota("Duke","Chihuahua",20,3.0F,"Moquillo","https://upload.wikimedia.org/wikipedia/commons/thumb/4/4c/Chihuahua1_bvdb.jpg/330px-Chihuahua1_bvdb.jpg",false,clienteRepository.findById(1579299760L).get()));
        mascotaRepository.save(new Mascota("Milo","CockerSpaniel",8,3.0F,"Parvovirus","https://upload.wikimedia.org/wikipedia/commons/thumb/0/03/Cocker_spaniel_called_Tony.jpg/300px-Cocker_spaniel_called_Tony.jpg",true,clienteRepository.findById(1463387523L).get()));
        mascotaRepository.save(new Mascota("Daisy","Rottweiler",15,22.0F,"Periodontal","https://upload.wikimedia.org/wikipedia/commons/thumb/0/04/Rottweiler_kopf_2.jpg/549px-Rottweiler_kopf_2.jpg",true,clienteRepository.findById(1050178599L).get()));
        mascotaRepository.save(new Mascota("Finn","Pug",4,18.0F,"Insuficiencia","https://upload.wikimedia.org/wikipedia/commons/thumb/6/63/Mops-falk-vom-maegdebrunnen-internationaler-champion-fci.jpg/330px-Mops-falk-vom-maegdebrunnen-internationaler-champion-fci.jpg",true,clienteRepository.findById(1307382282L).get()));
        mascotaRepository.save(new Mascota("Jack","Doberman",3,8.0F,"Rabia","https://upload.wikimedia.org/wikipedia/commons/thumb/6/6a/Jean_Dark_Sn%C3%B6_of_Sweden.jpg/330px-Jean_Dark_Sn%C3%B6_of_Sweden.jpg",false,clienteRepository.findById(1741434712L).get()));
        mascotaRepository.save(new Mascota("Shadow","Chihuahua",16,5.0F,"Obesidad","https://upload.wikimedia.org/wikipedia/commons/thumb/4/4c/Chihuahua1_bvdb.jpg/330px-Chihuahua1_bvdb.jpg",false,clienteRepository.findById(1524791740L).get()));
        mascotaRepository.save(new Mascota("Toby","Boxer",1,6.0F,"Obesidad","https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/HYPSO.JPG/169px-HYPSO.JPG",true,clienteRepository.findById(1880385151L).get()));
        mascotaRepository.save(new Mascota("Zeus","Poodle",13,7.0F,"Lyme","https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/Agility_Poodle.jpg/375px-Agility_Poodle.jpg",true,clienteRepository.findById(1160176480L).get()));
        mascotaRepository.save(new Mascota("Toby","Boxer",18,23.0F,"Dermatitis","https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/HYPSO.JPG/169px-HYPSO.JPG",true,clienteRepository.findById(1072306213L).get()));
        mascotaRepository.save(new Mascota("Mabel","Boxer",9,7.0F,"Epilepsia","https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/HYPSO.JPG/169px-HYPSO.JPG",true,clienteRepository.findById(1501134030L).get()));
        mascotaRepository.save(new Mascota("Bella","Pastor",9,21.0F,"Traqueobronquitis","https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Pastor_Alem%C3%A1n_hembra%2C_diez_a%C3%B1os_de_edad.jpg/330px-Pastor_Alem%C3%A1n_hembra%2C_diez_a%C3%B1os_de_edad.jpg",false,clienteRepository.findById(1207377727L).get()));
        mascotaRepository.save(new Mascota("Spike","CockerSpaniel",7,27.0F,"Rabia","https://upload.wikimedia.org/wikipedia/commons/thumb/0/03/Cocker_spaniel_called_Tony.jpg/300px-Cocker_spaniel_called_Tony.jpg",true,clienteRepository.findById(1460926052L).get()));
        mascotaRepository.save(new Mascota("Oliver","BordeCollie",12,17.0F,"Traqueobronquitis","https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Border_collie_canon.jpg/480px-Border_collie_canon.jpg",true,clienteRepository.findById(1159817334L).get()));
        mascotaRepository.save(new Mascota("Toby","Labrador",19,24.0F,"Dermatitis","https://upload.wikimedia.org/wikipedia/commons/thumb/0/04/Labrador_Retriever_%281210559%29.jpg/480px-Labrador_Retriever_%281210559%29.jpg",true,clienteRepository.findById(1807007174L).get()));
        mascotaRepository.save(new Mascota("Rocco","Golden",8,27.0F,"Hipotiroidismo","https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Golden_retriever%2C_Argentina.jpg/330px-Golden_retriever%2C_Argentina.jpg",true,clienteRepository.findById(1978101413L).get()));
        mascotaRepository.save(new Mascota("Oscar","Doberman",14,19.0F,"Rabia","https://upload.wikimedia.org/wikipedia/commons/thumb/6/6a/Jean_Dark_Sn%C3%B6_of_Sweden.jpg/330px-Jean_Dark_Sn%C3%B6_of_Sweden.jpg",false,clienteRepository.findById(1424794913L).get()));
        mascotaRepository.save(new Mascota("Oreo","Boxer",11,2.0F,"Traqueobronquitis","https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/HYPSO.JPG/169px-HYPSO.JPG",false,clienteRepository.findById(1608244321L).get()));
        mascotaRepository.save(new Mascota("Mocha","Pug",18,8.0F,"Leptospirosis","https://upload.wikimedia.org/wikipedia/commons/thumb/6/63/Mops-falk-vom-maegdebrunnen-internationaler-champion-fci.jpg/330px-Mops-falk-vom-maegdebrunnen-internationaler-champion-fci.jpg",true,clienteRepository.findById(1010231564L).get()));
        mascotaRepository.save(new Mascota("Thor","Beagle",5,30.0F,"Rabia","https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Shemsu_Sotis_Perun.jpg/480px-Shemsu_Sotis_Perun.jpg",true,clienteRepository.findById(1971408607L).get()));
        mascotaRepository.save(new Mascota("Toby","Bulldog",9,5.0F,"Leptospirosis","https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Racib%C3%B3rz_2007_082.jpg/480px-Racib%C3%B3rz_2007_082.jpg",true,clienteRepository.findById(1963427700L).get()));
        mascotaRepository.save(new Mascota("Rex","Boxer",9,20.0F,"Insuficiencia","https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/HYPSO.JPG/169px-HYPSO.JPG",true,clienteRepository.findById(1873486866L).get()));
        mascotaRepository.save(new Mascota("Daisy","Husky",6,30.0F,"Traqueobronquitis","https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Siberian-husky.jpg/480px-Siberian-husky.jpg",true,clienteRepository.findById(1410113199L).get()));
        mascotaRepository.save(new Mascota("Honey","BordeCollie",8,4.0F,"Pancreatitis","https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Border_collie_canon.jpg/480px-Border_collie_canon.jpg",true,clienteRepository.findById(1430947461L).get()));

    }
}
