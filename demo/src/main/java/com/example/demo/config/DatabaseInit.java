package com.example.demo.config;

import java.io.FileInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.Especialidad;
import com.example.demo.entity.Mascota;
import com.example.demo.entity.Medicamento;
import com.example.demo.entity.Role;
import com.example.demo.entity.Tratamiento;
import com.example.demo.entity.UserEntity;
import com.example.demo.entity.Veterinario;
import com.example.demo.entity.TratamientoMedicamento;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.EspecialidadRepository;
import com.example.demo.repository.MascotaRepository;
import com.example.demo.repository.MedicamentoRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.TratamientoRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.VeterinarioRepository;
import com.example.demo.repository.TratamientoMedicamentoRepository;
import com.example.demo.service.ExcelReaderService;

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
    @Autowired 
    TratamientoMedicamentoRepository tratamientoMedicamentoRepository;
    @Autowired 
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;

    @Autowired
    ExcelReaderService excelService;

    @Override
    public void run(ApplicationArguments args) throws Exception{
        UserEntity userEntity;

        //Creación roles
        roleRepository.save(new Role("ADMIN"));
        roleRepository.save(new Role("VET"));
        roleRepository.save(new Role("CLIENTE"));

        //Creación administrador
        Admin adminSave;
        adminSave = Admin.builder().usuario("admin").contrasena("admin").build();
        userEntity = saveUserAdmin(adminSave);
        adminSave.setUser(userEntity);
        adminRepository.save(adminSave);
        
        //Creación especialidad 
        especialidadRepository.save(Especialidad.builder().nombreEspecialidad("Cardiologo").build());
        especialidadRepository.save(Especialidad.builder().nombreEspecialidad("Nutrición").build());
        especialidadRepository.save(Especialidad.builder().nombreEspecialidad("Dermatología").build());
        especialidadRepository.save(Especialidad.builder().nombreEspecialidad("Oncología").build());
        especialidadRepository.save(Especialidad.builder().nombreEspecialidad("Toxicología").build());
        especialidadRepository.save(Especialidad.builder().nombreEspecialidad("Parasitología").build());
        especialidadRepository.save(Especialidad.builder().nombreEspecialidad("Neurología").build());
        especialidadRepository.save(Especialidad.builder().nombreEspecialidad("cirugía").build());
        
        Veterinario veterinarioSave;

        //Creación veterinario
        veterinarioSave = Veterinario.builder().cedula(1234L).contrasena("vet").foto("https://img.freepik.com/vector-gratis/grupo-personas-sonrientes-felices-mirando-vista-superior-ilustracion-vector-plano-fondo-blanco_1284-78599.jpg").nombre("Monica").estado(true).especialidad(especialidadRepository.findById(1L).get()).build();
        userEntity = saveUserVet(veterinarioSave);
        veterinarioSave.setUser(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = Veterinario.builder().cedula(43254180L).contrasena("starwars12").foto("https://img.freepik.com/vector-gratis/grupo-personas-sonrientes-felices-mirando-vista-superior-ilustracion-vector-plano-fondo-blanco_1284-78599.jpg").nombre("Jemima Gray").estado(true).especialidad(especialidadRepository.findById(7L).get()).build();
        userEntity = saveUserVet(veterinarioSave);
        veterinarioSave.setUser(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = Veterinario.builder().cedula(96163795L).contrasena("starfish09").foto("https://img.freepik.com/vector-gratis/grupo-personas-sonrientes-felices-mirando-vista-superior-ilustracion-vector-plano-fondo-blanco_1284-78599.jpg").nombre("Thor Frederick").estado(true).especialidad(especialidadRepository.findById(2L).get()).build();
        userEntity = saveUserVet(veterinarioSave);
        veterinarioSave.setUser(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = Veterinario.builder().cedula(32642703L).contrasena("treehouse22").foto("https://img.freepik.com/vector-gratis/grupo-personas-sonrientes-felices-mirando-vista-superior-ilustracion-vector-plano-fondo-blanco_1284-78599.jpg").nombre("Keefe Riley").estado(true).especialidad(especialidadRepository.findById(5L).get()).build();
        userEntity = saveUserVet(veterinarioSave);
        veterinarioSave.setUser(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = Veterinario.builder().cedula(90165479L).contrasena("pizza987").foto("https://img.freepik.com/vector-gratis/grupo-personas-sonrientes-felices-mirando-vista-superior-ilustracion-vector-plano-fondo-blanco_1284-78599.jpg").nombre("Ingrid Mcleod").estado(true).especialidad(especialidadRepository.findById(8L).get()).build();
        userEntity = saveUserVet(veterinarioSave);
        veterinarioSave.setUser(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = Veterinario.builder().cedula(74300275L).contrasena("fastcar11").foto("https://img.freepik.com/vector-gratis/grupo-personas-sonrientes-felices-mirando-vista-superior-ilustracion-vector-plano-fondo-blanco_1284-78599.jpg").nombre("Leah Wise").estado(true).especialidad(especialidadRepository.findById(3L).get()).build();
        userEntity = saveUserVet(veterinarioSave);
        veterinarioSave.setUser(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = Veterinario.builder().cedula(87970491L).contrasena("pizza987").foto("https://img.freepik.com/vector-gratis/grupo-personas-sonrientes-felices-mirando-vista-superior-ilustracion-vector-plano-fondo-blanco_1284-78599.jpg").nombre("Chaney Henderson").estado(true).especialidad(especialidadRepository.findById(6L).get()).build();
        userEntity = saveUserVet(veterinarioSave);
        veterinarioSave.setUser(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = Veterinario.builder().cedula(64065468L).contrasena("blackcat1").foto("https://img.freepik.com/vector-gratis/grupo-personas-sonrientes-felices-mirando-vista-superior-ilustracion-vector-plano-fondo-blanco_1284-78599.jpg").nombre("Lisandra Colon").estado(true).especialidad(especialidadRepository.findById(3L).get()).build();
        userEntity = saveUserVet(veterinarioSave);
        veterinarioSave.setUser(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = Veterinario.builder().cedula(11561735L).contrasena("chocolate1").foto("https://img.freepik.com/vector-gratis/grupo-personas-sonrientes-felices-mirando-vista-superior-ilustracion-vector-plano-fondo-blanco_1284-78599.jpg").nombre("Kelly Turner").estado(true).especialidad(especialidadRepository.findById(1L).get()).build();
        userEntity = saveUserVet(veterinarioSave);
        veterinarioSave.setUser(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = Veterinario.builder().cedula(42862669L).contrasena("hello12345").foto("https://img.freepik.com/vector-gratis/grupo-personas-sonrientes-felices-mirando-vista-superior-ilustracion-vector-plano-fondo-blanco_1284-78599.jpg").nombre("Ahmed Chambers").estado(true).especialidad(especialidadRepository.findById(5L).get()).build();
        userEntity = saveUserVet(veterinarioSave);
        veterinarioSave.setUser(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = Veterinario.builder().cedula(27244108L).contrasena("riverflow8").foto("https://img.freepik.com/vector-gratis/grupo-personas-sonrientes-felices-mirando-vista-superior-ilustracion-vector-plano-fondo-blanco_1284-78599.jpg").nombre("Quon Barr").estado(true).especialidad(especialidadRepository.findById(8L).get()).build();
        userEntity = saveUserVet(veterinarioSave);
        veterinarioSave.setUser(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = Veterinario.builder().cedula(90483162L).contrasena("secretpass1").foto("https://img.freepik.com/vector-gratis/grupo-personas-sonrientes-felices-mirando-vista-superior-ilustracion-vector-plano-fondo-blanco_1284-78599.jpg").nombre("Alexis Pearson").estado(false).especialidad(especialidadRepository.findById(2L).get()).build();
        userEntity = saveUserVet(veterinarioSave);
        veterinarioSave.setUser(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = Veterinario.builder().cedula(27200200L).contrasena("starfish09").foto("https://img.freepik.com/vector-gratis/grupo-personas-sonrientes-felices-mirando-vista-superior-ilustracion-vector-plano-fondo-blanco_1284-78599.jpg").nombre("Sierra Holder").estado(false).especialidad(especialidadRepository.findById(3L).get()).build();
        userEntity = saveUserVet(veterinarioSave);
        veterinarioSave.setUser(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = Veterinario.builder().cedula(94915788L).contrasena("summer2020").foto("https://img.freepik.com/vector-gratis/grupo-personas-sonrientes-felices-mirando-vista-superior-ilustracion-vector-plano-fondo-blanco_1284-78599.jpg").nombre("Kiara Aguilar").estado(false).especialidad(especialidadRepository.findById(7L).get()).build();
        userEntity = saveUserVet(veterinarioSave);
        veterinarioSave.setUser(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = Veterinario.builder().cedula(29085408L).contrasena("flower1234").foto("https://img.freepik.com/vector-gratis/grupo-personas-sonrientes-felices-mirando-vista-superior-ilustracion-vector-plano-fondo-blanco_1284-78599.jpg").nombre("Martena Sims").estado(false).especialidad(especialidadRepository.findById(6L).get()).build();
        userEntity = saveUserVet(veterinarioSave);
        veterinarioSave.setUser(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = Veterinario.builder().cedula(86992950L).contrasena("blackcat1").foto("https://img.freepik.com/vector-gratis/grupo-personas-sonrientes-felices-mirando-vista-superior-ilustracion-vector-plano-fondo-blanco_1284-78599.jpg").nombre("Brennan Middleton").estado(false).especialidad(especialidadRepository.findById(1L).get()).build();
        userEntity = saveUserVet(veterinarioSave);
        veterinarioSave.setUser(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = Veterinario.builder().cedula(38792985L).contrasena("computer98").foto("https://img.freepik.com/vector-gratis/grupo-personas-sonrientes-felices-mirando-vista-superior-ilustracion-vector-plano-fondo-blanco_1284-78599.jpg").nombre("Karleigh Hubbard").estado(false).especialidad(especialidadRepository.findById(4L).get()).build();
        userEntity = saveUserVet(veterinarioSave);
        veterinarioSave.setUser(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = Veterinario.builder().cedula(85472043L).contrasena("rainbow22").foto("https://img.freepik.com/vector-gratis/grupo-personas-sonrientes-felices-mirando-vista-superior-ilustracion-vector-plano-fondo-blanco_1284-78599.jpg").nombre("Nehru Dunn").estado(false).especialidad(especialidadRepository.findById(8L).get()).build();
        userEntity = saveUserVet(veterinarioSave);
        veterinarioSave.setUser(userEntity);
        veterinarioRepository.save(veterinarioSave);
        veterinarioSave = Veterinario.builder().cedula(1025321192L).contrasena("123").foto("https://img.freepik.com/vector-gratis/grupo-personas-sonrientes-felices-mirando-vista-superior-ilustracion-vector-plano-fondo-blanco_1284-78599.jpg").nombre("Alejandra Casas").estado(true).especialidad(especialidadRepository.findById(1L).get()).build();
        userEntity = saveUserVet(veterinarioSave);
        veterinarioSave.setUser(userEntity);
        veterinarioRepository.save(veterinarioSave);

        //Creación clientes
        Cliente clienteSave;

        clienteSave = new Cliente(1235062800L,"Dylan Richardson","facilisis.vitae@aol.org",309878724L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1640900910L,"Ignatius Compton","quis@yahoo.org",362491489L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1678516338L,"Ulric Wyatt","nam.nulla@icloud.ca",343261472L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1036204790L,"Fatima Duke","in.magna.phasellus@icloud.edu",352605555L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1189595192L,"Ramona Grant","vivamus.nibh.dolor@protonmail.ca",327982210L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1183244032L,"Kasper Riggs","sit.amet@outlook.edu",397804552L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1397485934L,"Maya Mckee","mi.pede@aol.couk",399530581L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1620457771L,"Walter O'brien","vel.est@icloud.ca",390253335L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1582417121L,"Kaseem Martinez","mattis.semper.dui@google.org",392755622L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1034035854L,"Uriah Summers","felis.ullamcorper@aol.ca",369992569L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1466299629L,"Murphy Shepard","maecenas.iaculis@aol.org",313644622L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1784649564L,"Nomlanga Montoya","lacus.nulla@hotmail.couk",370883016L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1463685994L,"Nyssa Stark","donec@protonmail.net",383581138L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1399417492L,"Cara Haynes","massa@yahoo.ca",320735830L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1508218624L,"Kenyon Atkins","cubilia.curae@google.net",305385837L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1261477208L,"Brianna Mercer","vulputate.lacus.cras@protonmail.com",336919594L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1798229791L,"Grace O'connor","et.nunc.quisque@protonmail.com",341209077L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1960954227L,"Jackson Burke","in@yahoo.ca",373618151L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1122533361L,"Lee Sherman","dictum.augue.malesuada@protonmail.net",353010632L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1823569570L,"Stone Head","semper@icloud.org",350562141L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1455442208L,"Lydia Garza","sit@outlook.net",311661409L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1572945473L,"Grady Kemp","nibh.dolor@yahoo.org",354768717L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1595362487L,"Hu Blevins","ultrices@outlook.org",320992125L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1331569072L,"Tiger Hardin","pellentesque.massa.lobortis@outlook.couk",341722894L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1708960240L,"Caryn Sampson","lorem.tristique@protonmail.edu",389899935L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1598085497L,"Zane Moreno","enim.sit.amet@google.couk",303549176L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1753745354L,"Abel Maldonado","eu.ultrices.sit@yahoo.edu",380912685L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1579299760L,"Cole Sanders","aliquam@icloud.edu",367149685L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1463387523L,"Philip Whitney","quisque@aol.ca",388499798L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1050178599L,"Hayden Park","neque@yahoo.edu",323061512L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1307382282L,"Gary Hines","tempus.scelerisque@google.net",385102160L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1741434712L,"Jarrod Evans","euismod@outlook.couk",344535101L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1524791740L,"Walter Kirby","erat.in@aol.net",354068407L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1880385151L,"Jillian Turner","cras.lorem.lorem@hotmail.edu",348773599L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1160176480L,"Duncan Mcconnell","eu@outlook.ca",325270189L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1072306213L,"Ann Head","blandit.nam@aol.couk",349087931L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1501134030L,"Victoria Reynolds","tempor.diam@google.ca",376534512L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1207377727L,"Bert West","erat@google.ca",372549668L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1460926052L,"Celeste Clark","lacus.cras@google.net",364496843L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1159817334L,"Abel Avila","egestas@protonmail.couk",324290880L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1807007174L,"Tarik Glenn","tempor.diam@icloud.couk",342726857L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1978101413L,"Jolie Curtis","ultricies.dignissim@google.ca",358103227L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1424794913L,"Mira Wyatt","urna.nullam@aol.ca",384779144L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1608244321L,"Alec Maldonado","ultrices@protonmail.net",304733602L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1010231564L,"Brett Kirby","elementum@aol.org",399341081L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1971408607L,"Harrison Moreno","in.lobortis@protonmail.couk",336215273L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1963427700L,"Dora Shields","id@protonmail.com",376298968L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1873486866L,"Lareina Roy","velit.dui.semper@outlook.org",341482251L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1410113199L,"Drake Glenn","in.at@icloud.ca",333104316L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
        clienteSave = new Cliente(1430947461L,"Rebecca Adkins","malesuada.augue@icloud.edu",357772405L);
        userEntity = saveUserCliente(clienteSave);
        clienteSave.setUser(userEntity);
        clienteRepository.save(clienteSave);
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
        medicamentoRepository.save(new Medicamento("Antibiótico A", 25.5D, 20.5D, 10, 50));
        medicamentoRepository.save(new Medicamento("Desparasitante B", 15.5D, 10.5D, 10, 0));
        medicamentoRepository.save(new Medicamento("Vacuna Rabia", 15.5D, 5.5D, 10, 0));
        medicamentoRepository.save(new Medicamento("Analgésico C", 44.5D, 4.5D, 10, 0));
        medicamentoRepository.save(new Medicamento("Antipulgas D", 66.5D, 6.5D, 10, 6));
        medicamentoRepository.save(new Medicamento("Antiinflamatorio E", 8.5D, 8.5D, 10, 0));
        medicamentoRepository.save(new Medicamento("Vacuna Moquillo", 99.5D, 9.5D, 10, 7));
        medicamentoRepository.save(new Medicamento("Suplemento Articular", 6.5D, 6.5D, 10, 0));
        medicamentoRepository.save(new Medicamento("Antibiótico F", 8.5D, 8.5D, 10, 0));
        medicamentoRepository.save(new Medicamento("Colirio Ocular", 6.5D, 6.5D, 10, 0));
        
        //Creación tratamiento
        tratamientoRepository.save(new Tratamiento(java.sql.Date.valueOf("2024-10-10"), veterinarioRepository.findById((long)1).get(), mascotaRepository.findById((long)1).get()));
        tratamientoRepository.save(new Tratamiento(java.sql.Date.valueOf("2025-11-11"), veterinarioRepository.findById((long)2).get(), mascotaRepository.findById((long)2).get()));
        tratamientoRepository.save(new Tratamiento(java.sql.Date.valueOf("2026-12-12"), veterinarioRepository.findById((long)3).get(), mascotaRepository.findById((long)3).get()));
        tratamientoRepository.save(new Tratamiento(java.sql.Date.valueOf("2023-02-20"), veterinarioRepository.findById((long)1).get(), mascotaRepository.findById((long)4).get()));
        tratamientoRepository.save(new Tratamiento(java.sql.Date.valueOf("2023-12-01"), veterinarioRepository.findById((long)4).get(), mascotaRepository.findById((long)1).get()));
        tratamientoRepository.save(new Tratamiento(java.sql.Date.valueOf("2023-10-07"), veterinarioRepository.findById((long)5).get(), mascotaRepository.findById((long)2).get()));
        tratamientoRepository.save(new Tratamiento(java.sql.Date.valueOf("2023-10-11"), veterinarioRepository.findById((long)2).get(), mascotaRepository.findById((long)5).get()));
        tratamientoRepository.save(new Tratamiento(java.sql.Date.valueOf("2021-03-12"), veterinarioRepository.findById((long)3).get(), mascotaRepository.findById((long)3).get()));
        tratamientoRepository.save(new Tratamiento(java.sql.Date.valueOf("2020-01-15"), veterinarioRepository.findById((long)4).get(), mascotaRepository.findById((long)4).get()));
        tratamientoRepository.save(new Tratamiento(java.sql.Date.valueOf("2022-11-22"), veterinarioRepository.findById((long)5).get(), mascotaRepository.findById((long)5).get()));

        String filePath = "demo/src/main/resources/files/MEDICAMENTOS_VETERINARIA.xlsx";

        // Lectura de medicamentos desde el archivo de excel
        try (InputStream inputStream = new FileInputStream(new File(filePath))) {
            
            List<Medicamento> listaMedicamentos = excelService.obtenerInfoMedicamento(inputStream);
            // Guardar en la base de datos
            for (Medicamento medicamento : listaMedicamentos) {
                medicamentoRepository.save(medicamento);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

         //Creación TratamientoMedicamento

        tratamientoMedicamentoRepository.save(new TratamientoMedicamento(tratamientoRepository.findById(1L).get(), medicamentoRepository.findById( 80L).get()));
        tratamientoMedicamentoRepository.save(new TratamientoMedicamento(tratamientoRepository.findById(1L).get(), medicamentoRepository.findById( 200L).get()));
        tratamientoMedicamentoRepository.save(new TratamientoMedicamento(tratamientoRepository.findById(1L).get(), medicamentoRepository.findById( 345L).get()));
        tratamientoMedicamentoRepository.save(new TratamientoMedicamento(tratamientoRepository.findById(2L).get(), medicamentoRepository.findById( 35L).get()));
        tratamientoMedicamentoRepository.save(new TratamientoMedicamento(tratamientoRepository.findById(2L).get(), medicamentoRepository.findById( 150L).get()));
        tratamientoMedicamentoRepository.save(new TratamientoMedicamento(tratamientoRepository.findById(3L).get(), medicamentoRepository.findById( 98L).get()));
        tratamientoMedicamentoRepository.save(new TratamientoMedicamento(tratamientoRepository.findById(4L).get(), medicamentoRepository.findById( 100L).get()));
        tratamientoMedicamentoRepository.save(new TratamientoMedicamento(tratamientoRepository.findById(4L).get(), medicamentoRepository.findById( 350L).get()));
        tratamientoMedicamentoRepository.save(new TratamientoMedicamento(tratamientoRepository.findById(4L).get(), medicamentoRepository.findById( 286L).get()));
        tratamientoMedicamentoRepository.save(new TratamientoMedicamento(tratamientoRepository.findById(4L).get(), medicamentoRepository.findById( 270L).get()));
        tratamientoMedicamentoRepository.save(new TratamientoMedicamento(tratamientoRepository.findById(5L).get(), medicamentoRepository.findById( 370L).get()));
        tratamientoMedicamentoRepository.save(new TratamientoMedicamento(tratamientoRepository.findById(6L).get(), medicamentoRepository.findById( 258L).get()));
        tratamientoMedicamentoRepository.save(new TratamientoMedicamento(tratamientoRepository.findById(7L).get(), medicamentoRepository.findById( 469L).get()));
        tratamientoMedicamentoRepository.save(new TratamientoMedicamento(tratamientoRepository.findById(7L).get(), medicamentoRepository.findById( 449L).get()));
        tratamientoMedicamentoRepository.save(new TratamientoMedicamento(tratamientoRepository.findById(8L).get(), medicamentoRepository.findById( 369L).get()));
        tratamientoMedicamentoRepository.save(new TratamientoMedicamento(tratamientoRepository.findById(8L).get(), medicamentoRepository.findById( 269L).get()));
        tratamientoMedicamentoRepository.save(new TratamientoMedicamento(tratamientoRepository.findById(8L).get(), medicamentoRepository.findById( 137L).get()));
        tratamientoMedicamentoRepository.save(new TratamientoMedicamento(tratamientoRepository.findById(9L).get(), medicamentoRepository.findById( 18L).get()));
        tratamientoMedicamentoRepository.save(new TratamientoMedicamento(tratamientoRepository.findById(10L).get(), medicamentoRepository.findById( 120L).get()));
        tratamientoMedicamentoRepository.save(new TratamientoMedicamento(tratamientoRepository.findById(10L).get(), medicamentoRepository.findById( 223L).get()));

    }

    private UserEntity saveUserAdmin(Admin admin){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(admin.getUsuario());
        userEntity.setPassword(passwordEncoder.encode(admin.getContrasena()));

        Role roles = roleRepository.findByName("ADMIN").get();
        userEntity.setRoles(List.of(roles));
        return userRepository.save(userEntity);
    }
    private UserEntity saveUserVet(Veterinario vet){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(String.valueOf(vet.getCedula()));
        userEntity.setPassword(passwordEncoder.encode(vet.getContrasena()));

        Role roles = roleRepository.findByName("VET").get();
        userEntity.setRoles(List.of(roles));
        return userRepository.save(userEntity);
    }
    private UserEntity saveUserCliente(Cliente cliente){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(String.valueOf(cliente.getCedula()));
        userEntity.setPassword(passwordEncoder.encode("123"));

        Role roles = roleRepository.findByName("CLIENTE").get();
        userEntity.setRoles(List.of(roles));
        return userRepository.save(userEntity);
    }
}
