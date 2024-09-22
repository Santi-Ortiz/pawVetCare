package com.example.demo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Especialidad;
import com.example.demo.entity.Mascota;
import com.example.demo.entity.Medicamento;
import com.example.demo.entity.Tratamiento;
import com.example.demo.entity.Veterinario;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.EspecialidadRepository;
import com.example.demo.repository.MascotaRepository;
import com.example.demo.repository.MedicamentoRepository;
import com.example.demo.repository.TratamientoRepository;
import com.example.demo.repository.VeterinarioRepository;

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
    @Autowired
    VeterinarioRepository veterinarioRepository;
    @Autowired
    EspecialidadRepository especialidadRepository;
    @Autowired
    TratamientoRepository tratamientoRepository;
    @Autowired
    MedicamentoRepository medicamentoRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception{

        //Creación administrador
        adminRepository.save(new Admin("admin","admin"));
        //Creación especialidad 
        especialidadRepository.save(new Especialidad("Cardiologo"));
        especialidadRepository.save(new Especialidad("Nutrición"));
        especialidadRepository.save(new Especialidad("Dermatología"));
        especialidadRepository.save(new Especialidad("Oncología"));
        especialidadRepository.save(new Especialidad("Toxicología"));
        especialidadRepository.save(new Especialidad("Parasitología"));
        especialidadRepository.save(new Especialidad("Neurología"));
        especialidadRepository.save(new Especialidad("cirugía"));
        
        //Creación veterinario
        veterinarioRepository.save(new Veterinario(1234L,"vet", "https://img.freepik.com/vector-gratis/grupo-personas-sonrientes-felices-mirando-vista-superior-ilustracion-vector-plano-fondo-blanco_1284-78599.jpg", "Monica", especialidadRepository.findById(1L).get()));
        veterinarioRepository.save(new Veterinario(43254180L,"starwars12","https://thispersondoesnotexist.com/","Jemima Gray",especialidadRepository.findById(7L).get()));
        veterinarioRepository.save(new Veterinario(96163795L,"starfish09","https://thispersondoesnotexist.com/","Thor Frederick",especialidadRepository.findById(2L).get()));
        veterinarioRepository.save(new Veterinario(32642703L,"treehouse22","https://thispersondoesnotexist.com/","Keefe Riley",especialidadRepository.findById(5L).get()));
        veterinarioRepository.save(new Veterinario(90165479L,"pizza987","https://thispersondoesnotexist.com/","Ingrid Mcleod",especialidadRepository.findById(8L).get()));
        veterinarioRepository.save(new Veterinario(74300275L,"fastcar11","https://thispersondoesnotexist.com/","Leah Wise",especialidadRepository.findById(3L).get()));
        veterinarioRepository.save(new Veterinario(87970491L,"pizza987","https://thispersondoesnotexist.com/","Chaney Henderson",especialidadRepository.findById(6L).get()));
        veterinarioRepository.save(new Veterinario(64065468L,"blackcat1","https://thispersondoesnotexist.com/","Lisandra Colon",especialidadRepository.findById(3L).get()));
        veterinarioRepository.save(new Veterinario(11561735L,"chocolate1","https://thispersondoesnotexist.com/","Kelly Turner",especialidadRepository.findById(1L).get()));
        veterinarioRepository.save(new Veterinario(42862669L,"hello12345","https://thispersondoesnotexist.com/","Ahmed Chambers",especialidadRepository.findById(5L).get()));
        veterinarioRepository.save(new Veterinario(27244108L,"riverflow8","https://thispersondoesnotexist.com/","Quon Barr",especialidadRepository.findById(8L).get()));
        veterinarioRepository.save(new Veterinario(90483162L,"secretpass1","https://thispersondoesnotexist.com/","Alexis Pearson",especialidadRepository.findById(2L).get()));
        veterinarioRepository.save(new Veterinario(27200200L,"starfish09","https://thispersondoesnotexist.com/","Sierra Holder",especialidadRepository.findById(3L).get()));
        veterinarioRepository.save(new Veterinario(94915788L,"summer2020","https://thispersondoesnotexist.com/","Kiara Aguilar",especialidadRepository.findById(7L).get()));
        veterinarioRepository.save(new Veterinario(29085408L,"flower1234","https://thispersondoesnotexist.com/","Martena Sims",especialidadRepository.findById(6L).get()));
        veterinarioRepository.save(new Veterinario(86992950L,"blackcat1","https://thispersondoesnotexist.com/","Brennan Middleton",especialidadRepository.findById(1L).get()));
        veterinarioRepository.save(new Veterinario(38792985L,"computer98","https://thispersondoesnotexist.com/","Karleigh Hubbard",especialidadRepository.findById(4L).get()));
        veterinarioRepository.save(new Veterinario(85472043L,"rainbow22","https://thispersondoesnotexist.com/","Nehru Dunn",especialidadRepository.findById(8L).get()));
        veterinarioRepository.save(new Veterinario(81045486L,"magicstar1","https://thispersondoesnotexist.com/","Austin Porter",especialidadRepository.findById(1L).get()));
        veterinarioRepository.save(new Veterinario(46069761L,"1q2w3e4r","https://thispersondoesnotexist.com/","Michael Tyson",especialidadRepository.findById(1L).get()));
        veterinarioRepository.save(new Veterinario(56409545L,"fireball2021","https://thispersondoesnotexist.com/","Nasim Orr",especialidadRepository.findById(4L).get()));

        //Creación clientes
        clienteRepository.save(new Cliente(1235062800L,"Dylan Richardson","facilisis.vitae@aol.org",309878724L));
        clienteRepository.save(new Cliente(1640900910L,"Ignatius Compton","quis@yahoo.org",362491489L));
        clienteRepository.save(new Cliente(1678516338L,"Ulric Wyatt","nam.nulla@icloud.ca",343261472L));
        clienteRepository.save(new Cliente(1036204790L,"Fatima Duke","in.magna.phasellus@icloud.edu",352605555L));
        clienteRepository.save(new Cliente(1189595192L,"Ramona Grant","vivamus.nibh.dolor@protonmail.ca",327982210L));
        clienteRepository.save(new Cliente(1183244032L,"Kasper Riggs","sit.amet@outlook.edu",397804552L));
        clienteRepository.save(new Cliente(1397485934L,"Maya Mckee","mi.pede@aol.couk",399530581L));
        clienteRepository.save(new Cliente(1620457771L,"Walter O'brien","vel.est@icloud.ca",390253335L));
        clienteRepository.save(new Cliente(1582417121L,"Kaseem Martinez","mattis.semper.dui@google.org",392755622L));
        clienteRepository.save(new Cliente(1034035854L,"Uriah Summers","felis.ullamcorper@aol.ca",369992569L));
        clienteRepository.save(new Cliente(1466299629L,"Murphy Shepard","maecenas.iaculis@aol.org",313644622L));
        clienteRepository.save(new Cliente(1784649564L,"Nomlanga Montoya","lacus.nulla@hotmail.couk",370883016L));
        clienteRepository.save(new Cliente(1463685994L,"Nyssa Stark","donec@protonmail.net",383581138L));
        clienteRepository.save(new Cliente(1399417492L,"Cara Haynes","massa@yahoo.ca",320735830L));
        clienteRepository.save(new Cliente(1508218624L,"Kenyon Atkins","cubilia.curae@google.net",305385837L));
        clienteRepository.save(new Cliente(1261477208L,"Brianna Mercer","vulputate.lacus.cras@protonmail.com",336919594L));
        clienteRepository.save(new Cliente(1798229791L,"Grace O'connor","et.nunc.quisque@protonmail.com",341209077L));
        clienteRepository.save(new Cliente(1960954227L,"Jackson Burke","in@yahoo.ca",373618151L));
        clienteRepository.save(new Cliente(1122533361L,"Lee Sherman","dictum.augue.malesuada@protonmail.net",353010632L));
        clienteRepository.save(new Cliente(1823569570L,"Stone Head","semper@icloud.org",350562141L));
        clienteRepository.save(new Cliente(1455442208L,"Lydia Garza","sit@outlook.net",311661409L));
        clienteRepository.save(new Cliente(1572945473L,"Grady Kemp","nibh.dolor@yahoo.org",354768717L));
        clienteRepository.save(new Cliente(1595362487L,"Hu Blevins","ultrices@outlook.org",320992125L));
        clienteRepository.save(new Cliente(1331569072L,"Tiger Hardin","pellentesque.massa.lobortis@outlook.couk",341722894L));
        clienteRepository.save(new Cliente(1708960240L,"Caryn Sampson","lorem.tristique@protonmail.edu",389899935L));
        clienteRepository.save(new Cliente(1598085497L,"Zane Moreno","enim.sit.amet@google.couk",303549176L));
        clienteRepository.save(new Cliente(1753745354L,"Abel Maldonado","eu.ultrices.sit@yahoo.edu",380912685L));
        clienteRepository.save(new Cliente(1579299760L,"Cole Sanders","aliquam@icloud.edu",367149685L));
        clienteRepository.save(new Cliente(1463387523L,"Philip Whitney","quisque@aol.ca",388499798L));
        clienteRepository.save(new Cliente(1050178599L,"Hayden Park","neque@yahoo.edu",323061512L));
        clienteRepository.save(new Cliente(1307382282L,"Gary Hines","tempus.scelerisque@google.net",385102160L));
        clienteRepository.save(new Cliente(1741434712L,"Jarrod Evans","euismod@outlook.couk",344535101L));
        clienteRepository.save(new Cliente(1524791740L,"Walter Kirby","erat.in@aol.net",354068407L));
        clienteRepository.save(new Cliente(1880385151L,"Jillian Turner","cras.lorem.lorem@hotmail.edu",348773599L));
        clienteRepository.save(new Cliente(1160176480L,"Duncan Mcconnell","eu@outlook.ca",325270189L));
        clienteRepository.save(new Cliente(1072306213L,"Ann Head","blandit.nam@aol.couk",349087931L));
        clienteRepository.save(new Cliente(1501134030L,"Victoria Reynolds","tempor.diam@google.ca",376534512L));
        clienteRepository.save(new Cliente(1207377727L,"Bert West","erat@google.ca",372549668L));
        clienteRepository.save(new Cliente(1460926052L,"Celeste Clark","lacus.cras@google.net",364496843L));
        clienteRepository.save(new Cliente(1159817334L,"Abel Avila","egestas@protonmail.couk",324290880L));
        clienteRepository.save(new Cliente(1807007174L,"Tarik Glenn","tempor.diam@icloud.couk",342726857L));
        clienteRepository.save(new Cliente(1978101413L,"Jolie Curtis","ultricies.dignissim@google.ca",358103227L));
        clienteRepository.save(new Cliente(1424794913L,"Mira Wyatt","urna.nullam@aol.ca",384779144L));
        clienteRepository.save(new Cliente(1608244321L,"Alec Maldonado","ultrices@protonmail.net",304733602L));
        clienteRepository.save(new Cliente(1010231564L,"Brett Kirby","elementum@aol.org",399341081L));
        clienteRepository.save(new Cliente(1971408607L,"Harrison Moreno","in.lobortis@protonmail.couk",336215273L));
        clienteRepository.save(new Cliente(1963427700L,"Dora Shields","id@protonmail.com",376298968L));
        clienteRepository.save(new Cliente(1873486866L,"Lareina Roy","velit.dui.semper@outlook.org",341482251L));
        clienteRepository.save(new Cliente(1410113199L,"Drake Glenn","in.at@icloud.ca",333104316L));
        clienteRepository.save(new Cliente(1430947461L,"Rebecca Adkins","malesuada.augue@icloud.edu",357772405L));
        //Creación mascotas
        mascotaRepository.save(new Mascota("Toby","Husky",2,24.0F,"Insuficiencia","https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Siberian-husky.jpg/480px-Siberian-husky.jpg",true,clienteRepository.findByCedula(1235062800L)));
        mascotaRepository.save(new Mascota("Pepper","Husky",2,12.0F,"Parvovirus","https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Siberian-husky.jpg/480px-Siberian-husky.jpg",true,clienteRepository.findByCedula(1640900910L)));
        mascotaRepository.save(new Mascota("Luna","Poodle",5,26.0F,"Traqueobronquitis","https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/Agility_Poodle.jpg/375px-Agility_Poodle.jpg",false,clienteRepository.findByCedula(1678516338L)));
        mascotaRepository.save(new Mascota("Lucky","Golden",5,27.0F,"Dermatitis","https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Golden_retriever%2C_Argentina.jpg/330px-Golden_retriever%2C_Argentina.jpg",false,clienteRepository.findByCedula(1036204790L)));
        mascotaRepository.save(new Mascota("Smokey","Golden",3,1.0F,"Cáncer","https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Golden_retriever%2C_Argentina.jpg/330px-Golden_retriever%2C_Argentina.jpg",false,clienteRepository.findByCedula(1189595192L)));
        mascotaRepository.save(new Mascota("Harley","CockerSpaniel",4,3.0F,"Epilepsia","https://upload.wikimedia.org/wikipedia/commons/thumb/0/03/Cocker_spaniel_called_Tony.jpg/300px-Cocker_spaniel_called_Tony.jpg",true,clienteRepository.findByCedula(1183244032L)));
        mascotaRepository.save(new Mascota("Lucy","Bulldog",14,10.0F,"Dirofilariasis","https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Racib%C3%B3rz_2007_082.jpg/480px-Racib%C3%B3rz_2007_082.jpg",false,clienteRepository.findByCedula(1397485934L)));
        mascotaRepository.save(new Mascota("Poppy","Dachshund",9,9.0F,"Pancreatitis","https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Dachshund_brown_puppy.jpg/330px-Dachshund_brown_puppy.jpg",false,clienteRepository.findByCedula(1620457771L)));
        mascotaRepository.save(new Mascota("Bella","Rottweiler",5,16.0F,"Cáncer","https://upload.wikimedia.org/wikipedia/commons/thumb/0/04/Rottweiler_kopf_2.jpg/549px-Rottweiler_kopf_2.jpg",true,clienteRepository.findByCedula(1582417121L)));
        mascotaRepository.save(new Mascota("Penny","Husky",2,13.0F,"Hipotiroidismo","https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Siberian-husky.jpg/480px-Siberian-husky.jpg",true,clienteRepository.findByCedula(1034035854L)));
        mascotaRepository.save(new Mascota("Sam","Pastor",14,26.0F,"Traqueobronquitis","https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Pastor_Alem%C3%A1n_hembra%2C_diez_a%C3%B1os_de_edad.jpg/330px-Pastor_Alem%C3%A1n_hembra%2C_diez_a%C3%B1os_de_edad.jpg",true,clienteRepository.findByCedula(1466299629L)));
        mascotaRepository.save(new Mascota("Winston","Bulldog",12,18.0F,"Dermatitis","https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Racib%C3%B3rz_2007_082.jpg/480px-Racib%C3%B3rz_2007_082.jpg",false,clienteRepository.findByCedula(1784649564L)));
        mascotaRepository.save(new Mascota("Maya","Poodle",8,7.0F,"Dirofilariasis","https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/Agility_Poodle.jpg/375px-Agility_Poodle.jpg",true,clienteRepository.findByCedula(1463685994L)));
        mascotaRepository.save(new Mascota("Misty","Dachshund",20,24.0F,"Dirofilariasis","https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Dachshund_brown_puppy.jpg/330px-Dachshund_brown_puppy.jpg",true,clienteRepository.findByCedula(1399417492L)));
        mascotaRepository.save(new Mascota("Oreo","BordeCollie",4,3.0F,"Traqueobronquitis","https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Border_collie_canon.jpg/480px-Border_collie_canon.jpg",false,clienteRepository.findByCedula(1508218624L)));
        mascotaRepository.save(new Mascota("Gizmo","Husky",0,23.0F,"Leptospirosis","https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Siberian-husky.jpg/480px-Siberian-husky.jpg",true,clienteRepository.findByCedula(1261477208L)));
        mascotaRepository.save(new Mascota("Oliver","Rottweiler",3,12.0F,"Traqueobronquitis","https://upload.wikimedia.org/wikipedia/commons/thumb/0/04/Rottweiler_kopf_2.jpg/549px-Rottweiler_kopf_2.jpg",true,clienteRepository.findByCedula(1798229791L)));
        mascotaRepository.save(new Mascota("Bruno","Doberman",13,8.0F,"Epilepsia","https://upload.wikimedia.org/wikipedia/commons/thumb/6/6a/Jean_Dark_Sn%C3%B6_of_Sweden.jpg/330px-Jean_Dark_Sn%C3%B6_of_Sweden.jpg",false,clienteRepository.findByCedula(1960954227L)));
        mascotaRepository.save(new Mascota("Penny","Boxer",4,22.0F,"Parvovirus","https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/HYPSO.JPG/169px-HYPSO.JPG",false,clienteRepository.findByCedula(1122533361L)));
        mascotaRepository.save(new Mascota("Rosie","Pastor",19,19.0F,"Parvovirus","https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Pastor_Alem%C3%A1n_hembra%2C_diez_a%C3%B1os_de_edad.jpg/330px-Pastor_Alem%C3%A1n_hembra%2C_diez_a%C3%B1os_de_edad.jpg",false,clienteRepository.findByCedula(1823569570L)));
        mascotaRepository.save(new Mascota("Oliver","Dachshund",0,3.0F,"Traqueobronquitis","https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Dachshund_brown_puppy.jpg/330px-Dachshund_brown_puppy.jpg",false,clienteRepository.findByCedula(1455442208L)));
        mascotaRepository.save(new Mascota("Rocco","Yorkshire",1,18.0F,"Lyme","https://upload.wikimedia.org/wikipedia/commons/a/ab/Lola%2C_Yorkshire_Terrier_de_treinta_meses.jpg",false,clienteRepository.findByCedula(1572945473L)));
        mascotaRepository.save(new Mascota("Thor","Rottweiler",3,27.0F,"Leptospirosis","https://upload.wikimedia.org/wikipedia/commons/thumb/0/04/Rottweiler_kopf_2.jpg/549px-Rottweiler_kopf_2.jpg",false,clienteRepository.findByCedula(1595362487L)));
        mascotaRepository.save(new Mascota("Oscar","Husky",13,1.0F,"Rabia","https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Siberian-husky.jpg/480px-Siberian-husky.jpg",false,clienteRepository.findByCedula(1331569072L)));
        mascotaRepository.save(new Mascota("Duke","Boxer",12,6.0F,"Insuficiencia","https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/HYPSO.JPG/169px-HYPSO.JPG",false,clienteRepository.findByCedula(1708960240L)));
        mascotaRepository.save(new Mascota("Hunter","Poodle",3,18.0F,"Insuficiencia","https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/Agility_Poodle.jpg/375px-Agility_Poodle.jpg",false,clienteRepository.findByCedula(1598085497L)));
        mascotaRepository.save(new Mascota("Zeus","Dachshund",7,7.0F,"Dermatitis","https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Dachshund_brown_puppy.jpg/330px-Dachshund_brown_puppy.jpg",true,clienteRepository.findByCedula(1753745354L)));
        mascotaRepository.save(new Mascota("Leo","Bulldog",9,24.0F,"Rabia","https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Racib%C3%B3rz_2007_082.jpg/480px-Racib%C3%B3rz_2007_082.jpg",false,clienteRepository.findByCedula(1579299760L)));
        mascotaRepository.save(new Mascota("Bandit","Yorkshire",10,8.0F,"Dermatitis","https://upload.wikimedia.org/wikipedia/commons/a/ab/Lola%2C_Yorkshire_Terrier_de_treinta_meses.jpg",true,clienteRepository.findByCedula(1463387523L)));
        mascotaRepository.save(new Mascota("Nala","Poodle",13,2.0F,"Epilepsia","https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/Agility_Poodle.jpg/375px-Agility_Poodle.jpg",false,clienteRepository.findByCedula(1050178599L)));
        mascotaRepository.save(new Mascota("Lucky","Husky",1,12.0F,"Dirofilariasis","https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Siberian-husky.jpg/480px-Siberian-husky.jpg",false,clienteRepository.findByCedula(1307382282L)));
        mascotaRepository.save(new Mascota("Willow","Bulldog",19,8.0F,"Insuficiencia","https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Racib%C3%B3rz_2007_082.jpg/480px-Racib%C3%B3rz_2007_082.jpg",false,clienteRepository.findByCedula(1741434712L)));
        mascotaRepository.save(new Mascota("Maya","Dachshund",0,1.0F,"Displasia","https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Dachshund_brown_puppy.jpg/330px-Dachshund_brown_puppy.jpg",true,clienteRepository.findByCedula(1524791740L)));
        mascotaRepository.save(new Mascota("Nala","Poodle",12,28.0F,"Moquillo","https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/Agility_Poodle.jpg/375px-Agility_Poodle.jpg",false,clienteRepository.findByCedula(1880385151L)));
        mascotaRepository.save(new Mascota("Cupcake","Bulldog",13,4.0F,"Periodontal","https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Racib%C3%B3rz_2007_082.jpg/480px-Racib%C3%B3rz_2007_082.jpg",true,clienteRepository.findByCedula(1160176480L)));
        mascotaRepository.save(new Mascota("Rocky","Pug",7,24.0F,"Displasia","https://upload.wikimedia.org/wikipedia/commons/thumb/6/63/Mops-falk-vom-maegdebrunnen-internationaler-champion-fci.jpg/330px-Mops-falk-vom-maegdebrunnen-internationaler-champion-fci.jpg",false,clienteRepository.findByCedula(1072306213L)));
        mascotaRepository.save(new Mascota("Mabel","Chihuahua",13,2.0F,"Sarna","https://upload.wikimedia.org/wikipedia/commons/thumb/4/4c/Chihuahua1_bvdb.jpg/330px-Chihuahua1_bvdb.jpg",true,clienteRepository.findByCedula(1501134030L)));
        mascotaRepository.save(new Mascota("Ivy","Dachshund",11,18.0F,"Displasia","https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Dachshund_brown_puppy.jpg/330px-Dachshund_brown_puppy.jpg",true,clienteRepository.findByCedula(1207377727L)));
        mascotaRepository.save(new Mascota("Spike","Doberman",6,15.0F,"Dirofilariasis","https://upload.wikimedia.org/wikipedia/commons/thumb/6/6a/Jean_Dark_Sn%C3%B6_of_Sweden.jpg/330px-Jean_Dark_Sn%C3%B6_of_Sweden.jpg",true,clienteRepository.findByCedula(1460926052L)));
        mascotaRepository.save(new Mascota("Niko","Boxer",9,17.0F,"Obesidad","https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/HYPSO.JPG/169px-HYPSO.JPG",true,clienteRepository.findByCedula(1159817334L)));
        mascotaRepository.save(new Mascota("Firulais","Labrador",1,12.0F,"Cáncer","https://upload.wikimedia.org/wikipedia/commons/thumb/0/04/Labrador_Retriever_%281210559%29.jpg/480px-Labrador_Retriever_%281210559%29.jpg",false,clienteRepository.findByCedula(1807007174L)));
        mascotaRepository.save(new Mascota("Teddy","Doberman",5,26.0F,"Obesidad","https://upload.wikimedia.org/wikipedia/commons/thumb/6/6a/Jean_Dark_Sn%C3%B6_of_Sweden.jpg/330px-Jean_Dark_Sn%C3%B6_of_Sweden.jpg",true,clienteRepository.findByCedula(1978101413L)));
        mascotaRepository.save(new Mascota("Rex","CockerSpaniel",12,26.0F,"Sarna","https://upload.wikimedia.org/wikipedia/commons/thumb/0/03/Cocker_spaniel_called_Tony.jpg/300px-Cocker_spaniel_called_Tony.jpg",false,clienteRepository.findByCedula(1424794913L)));
        mascotaRepository.save(new Mascota("Angel","Boxer",19,24.0F,"Lyme","https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/HYPSO.JPG/169px-HYPSO.JPG",true,clienteRepository.findByCedula(1608244321L)));
        mascotaRepository.save(new Mascota("Penny","Dachshund",18,2.0F,"Moquillo","https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Dachshund_brown_puppy.jpg/330px-Dachshund_brown_puppy.jpg",false,clienteRepository.findByCedula(1010231564L)));
        mascotaRepository.save(new Mascota("Bandit","Yorkshire",5,8.0F,"Displasia","https://upload.wikimedia.org/wikipedia/commons/a/ab/Lola%2C_Yorkshire_Terrier_de_treinta_meses.jpg",false,clienteRepository.findByCedula(1971408607L)));
        mascotaRepository.save(new Mascota("Niko","Rottweiler",4,7.0F,"Insuficiencia","https://upload.wikimedia.org/wikipedia/commons/thumb/0/04/Rottweiler_kopf_2.jpg/549px-Rottweiler_kopf_2.jpg",true,clienteRepository.findByCedula(1963427700L)));
        mascotaRepository.save(new Mascota("Toby","Beagle",17,5.0F,"Hipotiroidismo","https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Shemsu_Sotis_Perun.jpg/480px-Shemsu_Sotis_Perun.jpg",false,clienteRepository.findByCedula(1873486866L)));
        mascotaRepository.save(new Mascota("Lucky","Husky",7,3.0F,"Cáncer","https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Siberian-husky.jpg/480px-Siberian-husky.jpg",true,clienteRepository.findByCedula(1410113199L)));
        mascotaRepository.save(new Mascota("Chloe","BordeCollie",10,9.0F,"Obesidad","https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Border_collie_canon.jpg/480px-Border_collie_canon.jpg",true,clienteRepository.findByCedula(1430947461L)));
        mascotaRepository.save(new Mascota("Mabel","Husky",19,17.0F,"Obesidad","https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Siberian-husky.jpg/480px-Siberian-husky.jpg",true,clienteRepository.findByCedula(1235062800L)));
        mascotaRepository.save(new Mascota("Leo","Boxer",17,10.0F,"Sarna","https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/HYPSO.JPG/169px-HYPSO.JPG",false,clienteRepository.findByCedula(1640900910L)));
        mascotaRepository.save(new Mascota("Sasha","Chihuahua",14,11.0F,"Lyme","https://upload.wikimedia.org/wikipedia/commons/thumb/4/4c/Chihuahua1_bvdb.jpg/330px-Chihuahua1_bvdb.jpg",true,clienteRepository.findByCedula(1678516338L)));
        mascotaRepository.save(new Mascota("Ace","Yorkshire",5,5.0F,"Lyme","https://upload.wikimedia.org/wikipedia/commons/a/ab/Lola%2C_Yorkshire_Terrier_de_treinta_meses.jpg",true,clienteRepository.findByCedula(1036204790L)));
        mascotaRepository.save(new Mascota("Jasper","Pug",6,14.0F,"Dirofilariasis","https://upload.wikimedia.org/wikipedia/commons/thumb/6/63/Mops-falk-vom-maegdebrunnen-internationaler-champion-fci.jpg/330px-Mops-falk-vom-maegdebrunnen-internationaler-champion-fci.jpg",false,clienteRepository.findByCedula(1189595192L)));
        mascotaRepository.save(new Mascota("Ruby","Doberman",4,6.0F,"Hipotiroidismo","https://upload.wikimedia.org/wikipedia/commons/thumb/6/6a/Jean_Dark_Sn%C3%B6_of_Sweden.jpg/330px-Jean_Dark_Sn%C3%B6_of_Sweden.jpg",false,clienteRepository.findByCedula(1183244032L)));
        mascotaRepository.save(new Mascota("Hunter","Dachshund",11,5.0F,"Insuficiencia","https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Dachshund_brown_puppy.jpg/330px-Dachshund_brown_puppy.jpg",true,clienteRepository.findByCedula(1397485934L)));
        mascotaRepository.save(new Mascota("Oliver","Dachshund",14,23.0F,"Leptospirosis","https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Dachshund_brown_puppy.jpg/330px-Dachshund_brown_puppy.jpg",true,clienteRepository.findByCedula(1620457771L)));
        mascotaRepository.save(new Mascota("Loki","Pug",20,15.0F,"Leptospirosis","https://upload.wikimedia.org/wikipedia/commons/thumb/6/63/Mops-falk-vom-maegdebrunnen-internationaler-champion-fci.jpg/330px-Mops-falk-vom-maegdebrunnen-internationaler-champion-fci.jpg",true,clienteRepository.findByCedula(1582417121L)));
        mascotaRepository.save(new Mascota("Lily","Pastor",8,16.0F,"Insuficiencia","https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Pastor_Alem%C3%A1n_hembra%2C_diez_a%C3%B1os_de_edad.jpg/330px-Pastor_Alem%C3%A1n_hembra%2C_diez_a%C3%B1os_de_edad.jpg",false,clienteRepository.findByCedula(1034035854L)));
        mascotaRepository.save(new Mascota("Muffin","Beagle",13,16.0F,"Hipotiroidismo","https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Shemsu_Sotis_Perun.jpg/480px-Shemsu_Sotis_Perun.jpg",false,clienteRepository.findByCedula(1466299629L)));
        mascotaRepository.save(new Mascota("Toby","Bulldog",1,25.0F,"Otitis","https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Racib%C3%B3rz_2007_082.jpg/480px-Racib%C3%B3rz_2007_082.jpg",false,clienteRepository.findByCedula(1784649564L)));
        mascotaRepository.save(new Mascota("Poppy","Pastor",1,11.0F,"Cáncer","https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Pastor_Alem%C3%A1n_hembra%2C_diez_a%C3%B1os_de_edad.jpg/330px-Pastor_Alem%C3%A1n_hembra%2C_diez_a%C3%B1os_de_edad.jpg",false,clienteRepository.findByCedula(1463685994L)));
        mascotaRepository.save(new Mascota("Maya","Golden",14,8.0F,"Traqueobronquitis","https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Golden_retriever%2C_Argentina.jpg/330px-Golden_retriever%2C_Argentina.jpg",true,clienteRepository.findByCedula(1399417492L)));
        mascotaRepository.save(new Mascota("Jake","Dachshund",15,1.0F,"Dermatitis","https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Dachshund_brown_puppy.jpg/330px-Dachshund_brown_puppy.jpg",false,clienteRepository.findByCedula(1508218624L)));
        mascotaRepository.save(new Mascota("Mabel","Yorkshire",6,29.0F,"Moquillo","https://upload.wikimedia.org/wikipedia/commons/a/ab/Lola%2C_Yorkshire_Terrier_de_treinta_meses.jpg",false,clienteRepository.findByCedula(1261477208L)));
        mascotaRepository.save(new Mascota("Ziggy","Labrador",11,12.0F,"Pancreatitis","https://upload.wikimedia.org/wikipedia/commons/thumb/0/04/Labrador_Retriever_%281210559%29.jpg/480px-Labrador_Retriever_%281210559%29.jpg",false,clienteRepository.findByCedula(1798229791L)));
        mascotaRepository.save(new Mascota("Bruno","Dachshund",5,18.0F,"Artritis","https://upload.wikimedia.org/wikipedia/commons/thumb/b/b9/Dachshund_brown_puppy.jpg/330px-Dachshund_brown_puppy.jpg",true,clienteRepository.findByCedula(1960954227L)));
        mascotaRepository.save(new Mascota("Rex","Pug",1,26.0F,"Otitis","https://upload.wikimedia.org/wikipedia/commons/thumb/6/63/Mops-falk-vom-maegdebrunnen-internationaler-champion-fci.jpg/330px-Mops-falk-vom-maegdebrunnen-internationaler-champion-fci.jpg",false,clienteRepository.findByCedula(1122533361L)));
        mascotaRepository.save(new Mascota("Lucky","Beagle",12,10.0F,"Cáncer","https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Shemsu_Sotis_Perun.jpg/480px-Shemsu_Sotis_Perun.jpg",true,clienteRepository.findByCedula(1823569570L)));
        mascotaRepository.save(new Mascota("Daisy","Beagle",11,4.0F,"Cáncer","https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Shemsu_Sotis_Perun.jpg/480px-Shemsu_Sotis_Perun.jpg",false,clienteRepository.findByCedula(1455442208L)));
        mascotaRepository.save(new Mascota("Winston","Golden",17,23.0F,"Rabia","https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Golden_retriever%2C_Argentina.jpg/330px-Golden_retriever%2C_Argentina.jpg",false,clienteRepository.findByCedula(1572945473L)));
        mascotaRepository.save(new Mascota("Jack","Yorkshire",9,24.0F,"Cáncer","https://upload.wikimedia.org/wikipedia/commons/a/ab/Lola%2C_Yorkshire_Terrier_de_treinta_meses.jpg",false,clienteRepository.findByCedula(1595362487L)));
        mascotaRepository.save(new Mascota("Ruby","Golden",14,6.0F,"Obesidad","https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Golden_retriever%2C_Argentina.jpg/330px-Golden_retriever%2C_Argentina.jpg",true,clienteRepository.findByCedula(1331569072L)));
        mascotaRepository.save(new Mascota("Poppy","Chihuahua",4,21.0F,"Periodontal","https://upload.wikimedia.org/wikipedia/commons/thumb/4/4c/Chihuahua1_bvdb.jpg/330px-Chihuahua1_bvdb.jpg",false,clienteRepository.findByCedula(1708960240L)));
        mascotaRepository.save(new Mascota("Midnight","CockerSpaniel",5,12.0F,"Traqueobronquitis","Foto",true,clienteRepository.findByCedula(1598085497L)));
        mascotaRepository.save(new Mascota("Rex","Pastor",3,22.0F,"Lyme","https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Pastor_Alem%C3%A1n_hembra%2C_diez_a%C3%B1os_de_edad.jpg/330px-Pastor_Alem%C3%A1n_hembra%2C_diez_a%C3%B1os_de_edad.jpg",false,clienteRepository.findByCedula(1753745354L)));
        mascotaRepository.save(new Mascota("Duke","Chihuahua",20,3.0F,"Moquillo","https://upload.wikimedia.org/wikipedia/commons/thumb/4/4c/Chihuahua1_bvdb.jpg/330px-Chihuahua1_bvdb.jpg",false,clienteRepository.findByCedula(1579299760L)));
        mascotaRepository.save(new Mascota("Milo","CockerSpaniel",8,3.0F,"Parvovirus","https://upload.wikimedia.org/wikipedia/commons/thumb/0/03/Cocker_spaniel_called_Tony.jpg/300px-Cocker_spaniel_called_Tony.jpg",true,clienteRepository.findByCedula(1463387523L)));
        mascotaRepository.save(new Mascota("Daisy","Rottweiler",15,22.0F,"Periodontal","https://upload.wikimedia.org/wikipedia/commons/thumb/0/04/Rottweiler_kopf_2.jpg/549px-Rottweiler_kopf_2.jpg",true,clienteRepository.findByCedula(1050178599L)));
        mascotaRepository.save(new Mascota("Finn","Pug",4,18.0F,"Insuficiencia","https://upload.wikimedia.org/wikipedia/commons/thumb/6/63/Mops-falk-vom-maegdebrunnen-internationaler-champion-fci.jpg/330px-Mops-falk-vom-maegdebrunnen-internationaler-champion-fci.jpg",true,clienteRepository.findByCedula(1307382282L)));
        mascotaRepository.save(new Mascota("Jack","Doberman",3,8.0F,"Rabia","https://upload.wikimedia.org/wikipedia/commons/thumb/6/6a/Jean_Dark_Sn%C3%B6_of_Sweden.jpg/330px-Jean_Dark_Sn%C3%B6_of_Sweden.jpg",false,clienteRepository.findByCedula(1741434712L)));
        mascotaRepository.save(new Mascota("Shadow","Chihuahua",16,5.0F,"Obesidad","https://upload.wikimedia.org/wikipedia/commons/thumb/4/4c/Chihuahua1_bvdb.jpg/330px-Chihuahua1_bvdb.jpg",false,clienteRepository.findByCedula(1524791740L)));
        mascotaRepository.save(new Mascota("Toby","Boxer",1,6.0F,"Obesidad","https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/HYPSO.JPG/169px-HYPSO.JPG",true,clienteRepository.findByCedula(1880385151L)));
        mascotaRepository.save(new Mascota("Zeus","Poodle",13,7.0F,"Lyme","https://upload.wikimedia.org/wikipedia/commons/thumb/3/35/Agility_Poodle.jpg/375px-Agility_Poodle.jpg",true,clienteRepository.findByCedula(1160176480L)));
        mascotaRepository.save(new Mascota("Toby","Boxer",18,23.0F,"Dermatitis","https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/HYPSO.JPG/169px-HYPSO.JPG",true,clienteRepository.findByCedula(1072306213L)));
        mascotaRepository.save(new Mascota("Mabel","Boxer",9,7.0F,"Epilepsia","https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/HYPSO.JPG/169px-HYPSO.JPG",true,clienteRepository.findByCedula(1501134030L)));
        mascotaRepository.save(new Mascota("Bella","Pastor",9,21.0F,"Traqueobronquitis","https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Pastor_Alem%C3%A1n_hembra%2C_diez_a%C3%B1os_de_edad.jpg/330px-Pastor_Alem%C3%A1n_hembra%2C_diez_a%C3%B1os_de_edad.jpg",false,clienteRepository.findByCedula(1207377727L)));
        mascotaRepository.save(new Mascota("Spike","CockerSpaniel",7,27.0F,"Rabia","https://upload.wikimedia.org/wikipedia/commons/thumb/0/03/Cocker_spaniel_called_Tony.jpg/300px-Cocker_spaniel_called_Tony.jpg",true,clienteRepository.findByCedula(1460926052L)));
        mascotaRepository.save(new Mascota("Oliver","BordeCollie",12,17.0F,"Traqueobronquitis","https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Border_collie_canon.jpg/480px-Border_collie_canon.jpg",true,clienteRepository.findByCedula(1159817334L)));
        mascotaRepository.save(new Mascota("Toby","Labrador",19,24.0F,"Dermatitis","https://upload.wikimedia.org/wikipedia/commons/thumb/0/04/Labrador_Retriever_%281210559%29.jpg/480px-Labrador_Retriever_%281210559%29.jpg",true,clienteRepository.findByCedula(1807007174L)));
        mascotaRepository.save(new Mascota("Rocco","Golden",8,27.0F,"Hipotiroidismo","https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Golden_retriever%2C_Argentina.jpg/330px-Golden_retriever%2C_Argentina.jpg",true,clienteRepository.findByCedula(1978101413L)));
        mascotaRepository.save(new Mascota("Oscar","Doberman",14,19.0F,"Rabia","https://upload.wikimedia.org/wikipedia/commons/thumb/6/6a/Jean_Dark_Sn%C3%B6_of_Sweden.jpg/330px-Jean_Dark_Sn%C3%B6_of_Sweden.jpg",false,clienteRepository.findByCedula(1424794913L)));
        mascotaRepository.save(new Mascota("Oreo","Boxer",11,2.0F,"Traqueobronquitis","https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/HYPSO.JPG/169px-HYPSO.JPG",false,clienteRepository.findByCedula(1608244321L)));
        mascotaRepository.save(new Mascota("Mocha","Pug",18,8.0F,"Leptospirosis","https://upload.wikimedia.org/wikipedia/commons/thumb/6/63/Mops-falk-vom-maegdebrunnen-internationaler-champion-fci.jpg/330px-Mops-falk-vom-maegdebrunnen-internationaler-champion-fci.jpg",true,clienteRepository.findByCedula(1010231564L)));
        mascotaRepository.save(new Mascota("Thor","Beagle",5,30.0F,"Rabia","https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Shemsu_Sotis_Perun.jpg/480px-Shemsu_Sotis_Perun.jpg",true,clienteRepository.findByCedula(1971408607L)));
        mascotaRepository.save(new Mascota("Toby","Bulldog",9,5.0F,"Leptospirosis","https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Racib%C3%B3rz_2007_082.jpg/480px-Racib%C3%B3rz_2007_082.jpg",true,clienteRepository.findByCedula(1963427700L)));
        mascotaRepository.save(new Mascota("Rex","Boxer",9,20.0F,"Insuficiencia","https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/HYPSO.JPG/169px-HYPSO.JPG",true,clienteRepository.findByCedula(1873486866L)));
        mascotaRepository.save(new Mascota("Daisy","Husky",6,30.0F,"Traqueobronquitis","https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Siberian-husky.jpg/480px-Siberian-husky.jpg",true,clienteRepository.findByCedula(1410113199L)));
        mascotaRepository.save(new Mascota("Honey","BordeCollie",8,4.0F,"Pancreatitis","https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Border_collie_canon.jpg/480px-Border_collie_canon.jpg",true,clienteRepository.findByCedula(1430947461L)));
        
        //Creación Medicamentos
        medicamentoRepository.save(new Medicamento("Antibiótico A", "Medicamento para infecciones bacterianas", java.sql.Date.valueOf("2025-03-15")));
        medicamentoRepository.save(new Medicamento("Desparasitante B", "Desparasitante interno para perros y gatos", java.sql.Date.valueOf("2024-09-30")));
        medicamentoRepository.save(new Medicamento("Vacuna Rabia", "Vacuna contra la rabia, una dosis anual", java.sql.Date.valueOf("2026-01-10")));
        medicamentoRepository.save(new Medicamento("Analgésico C", "Analgésico de uso veterinario para el dolor agudo", java.sql.Date.valueOf("2023-12-01")));
        medicamentoRepository.save(new Medicamento("Antipulgas D", "Solución tópica para control de pulgas", java.sql.Date.valueOf("2025-05-20")));
        medicamentoRepository.save(new Medicamento("Antiinflamatorio E", "Medicamento antiinflamatorio no esteroide", java.sql.Date.valueOf("2024-07-15")));
        medicamentoRepository.save(new Medicamento("Vacuna Moquillo", "Vacuna para prevenir el moquillo canino", java.sql.Date.valueOf("2026-02-25")));
        medicamentoRepository.save(new Medicamento("Suplemento Articular", "Suplemento para mejorar la salud de las articulaciones", java.sql.Date.valueOf("2025-09-11")));
        medicamentoRepository.save(new Medicamento("Antibiótico F", "Antibiótico de amplio espectro", java.sql.Date.valueOf("2024-11-05")));
        medicamentoRepository.save(new Medicamento("Colirio Ocular", "Colirio para tratamiento de infecciones oculares", java.sql.Date.valueOf("2023-10-22")));
        
        //Creación tratamiento
        tratamientoRepository.save(new Tratamiento(java.sql.Date.valueOf("2024-08-15"), veterinarioRepository.findById((long)1).get(), mascotaRepository.findById((long)1).get()));
        tratamientoRepository.save(new Tratamiento(java.sql.Date.valueOf("2024-09-10"), veterinarioRepository.findById((long)2).get(), mascotaRepository.findById((long)2).get()));
        tratamientoRepository.save(new Tratamiento(java.sql.Date.valueOf("2025-01-05"), veterinarioRepository.findById((long)3).get(), mascotaRepository.findById((long)3).get()));
        tratamientoRepository.save(new Tratamiento(java.sql.Date.valueOf("2025-02-20"), veterinarioRepository.findById((long)1).get(), mascotaRepository.findById((long)4).get()));
        tratamientoRepository.save(new Tratamiento(java.sql.Date.valueOf("2023-12-01"), veterinarioRepository.findById((long)4).get(), mascotaRepository.findById((long)1).get()));
        tratamientoRepository.save(new Tratamiento(java.sql.Date.valueOf("2024-07-07"), veterinarioRepository.findById((long)5).get(), mascotaRepository.findById((long)2).get()));
        tratamientoRepository.save(new Tratamiento(java.sql.Date.valueOf("2024-10-11"), veterinarioRepository.findById((long)2).get(), mascotaRepository.findById((long)5).get()));
        tratamientoRepository.save(new Tratamiento(java.sql.Date.valueOf("2025-03-12"), veterinarioRepository.findById((long)3).get(), mascotaRepository.findById((long)3).get()));
        tratamientoRepository.save(new Tratamiento(java.sql.Date.valueOf("2025-01-15"), veterinarioRepository.findById((long)4).get(), mascotaRepository.findById((long)4).get()));
        tratamientoRepository.save(new Tratamiento(java.sql.Date.valueOf("2024-11-22"), veterinarioRepository.findById((long)5).get(), mascotaRepository.findById((long)5).get()));

    }
}
