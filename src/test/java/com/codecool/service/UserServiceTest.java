package com.codecool.service;

import com.codecool.user.UserRepository;
import com.codecool.user.UserService;
import com.codecool.user.domain.AppUser;
import com.codecool.user.dto.AppUserDTO;
import com.codecool.user.dto.UserAddressDTO;
import com.codecool.user.dto.UserNameDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

  @InjectMocks
  UserService userService;

  @Mock
  UserRepository userRepository;

  @Test
  public void should_return_all_users() {
    //given:
    when(userRepository.findAll()).thenReturn(prepareMockData());

    //when
    List<AppUser> users = userService.getAllAppUsers();

    //then:
    assertEquals(4, users.size());
    assertEquals("Joanna", users.get(0).getFirstName());
    assertEquals("Miłosz", users.get(2).getFirstName());
  }

  @Test
  public void should_return_only_when_IsAdmin_is_true() {
    //given:
    when(userRepository.findAll()).thenReturn(prepareMockData());

    //when
    List<AppUserDTO> admins = userService.getAllAdmins();

    //then:
    assertEquals(2, admins.size());
    assertEquals("Joanna", admins.get(0).getFirstName());
    assertEquals("Miłosz", admins.get(1).getFirstName());
  }

  @Test
  public void should_return_only_when_IsAdmin_is_false() {
    //given:
    when(userRepository.findAll()).thenReturn(prepareMockData());

    //when:
    List<AppUserDTO> rentersList = userService.getAllRenters();

    //then:
    assertEquals(2, rentersList.size());
    assertEquals("Rafał", rentersList.get(0).getFirstName());
    assertEquals("Michał", rentersList.get(1).getFirstName());
  }

  @Test
  public void should_return_user_addressDTO_when_item_id_is_passed() {
    //given
//    when(userRepository.findAppUserAddressByItemId(1)).thenReturn(prepareUserAddress());
    //when:
    UserAddressDTO userAddressDTO = userService.getUserAddressByItemId(1);

    //then:
//    verify(userRepository, times(1)).findAppUserAddressByItemId(1);
    assertEquals("Kraków", userAddressDTO.getCity());
    assertEquals("Karmelicka 9", userAddressDTO.getAddress());
  }

  @Test
  public void should_return_user_nameDTO_when_item_id_is_passed() {
    //given
//    when(userRepository.findAppUserNmeByItemId(1)).thenReturn(prepareFullUserName());

    //when:
    UserNameDTO userNameDTO = userService.getUserNameByItemId(1);

    //then:
//    verify(userRepository, times(1)).findAppUserNmeByItemId(1);
    assertEquals("Jan", userNameDTO.getFirstName());
    assertEquals("Truskolaski", userNameDTO.getLastName());

  }

  private List<AppUser> prepareMockData() {
    AppUser appUser1 = new AppUser();
    appUser1.setFirstName("Joanna");
    appUser1.setIsAdmin(true);
    appUser1.setEmail("jbrzuchacz@gmail.com");

    AppUser appUser2 = new AppUser();
    appUser2.setFirstName("Rafał");
    appUser2.setIsAdmin(false);
    appUser2.setEmail("jbrzuchacz@gmail.com");

    AppUser appUser3 = new AppUser();
    appUser3.setFirstName("Miłosz");
    appUser3.setIsAdmin(true);
    appUser3.setEmail("mbryla@gmail.com");

    AppUser appUser4 = new AppUser();
    appUser4.setFirstName("Michał");
    appUser4.setIsAdmin(false);
    appUser4.setEmail("mkuk@gmail.com");

    return of(appUser1, appUser2, appUser3, appUser4);
  }

  private String[] prepareUserAddress() {
    return new String[] { "Karmelicka 9,Kraków,31-807", "" };
  }

  private String prepareFullUserName() {
    return "Jan,Truskolaski";
  }
}
