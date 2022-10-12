program happy


  implicit none
  type data_point
      integer :: number
      real :: normed_value
  end type data_point
  integer :: number,number2
  
        
  !print *,'Enter First Arguement: '
  !Read *, number  
  !print *, 'Enter Second Arguement: '
  !Read *, number2 
  !integer :: NumsTotal
  !NumsTotal = number2 - number

  type(data_point):: d(10000),temp
  !allocate(d(10))
  integer, parameter :: find = 30
  integer :: found,i,j
  !integer :: number,number2
  integer :: count
  integer :: number3 
  real :: normedValue
  integer :: lsup,bubble
  lsup=10

  d%number = 0
  d%normed_value = 0.
  number2 = 30
  found = 0
  number = 10
  count=1
  print*, 'Enter first arguement: '
  read*, number

  print*, 'Enter second arguement: '
  read*, number2
  number3 = number2 - number
    
  !type(data_point) dimension(number3):: d


  do while( number <=number2)
    !if (found == number2) then
     ! exit
    !end if
    if (is_happy (number)) then

      !found = found + 1
      !number2 = number2 +1
      normedValue = sqrt(real((number**2+breakdown(number) + 1)))
      d(count)%normed_value=normedValue
      

      write (*, '(i0)') number
      d(count)%number = number
      count = count + 1
    end if
    number = number + 1
  end do

  do i=1,10
  lsup=10
  do while (lsup > 1)
    bubble = 0
    temp%normed_value = 0.
    temp%number = 0
    do j = 2, lsup
         if (d(j)%normed_value > d(j-1)%normed_value) then
            temp = d(j)
            d(j) = d(j-1)
            d(j-1) = temp
         end if
      lsup = bubble
    end do
 end do

end do


  do i = 1,10
    if(d(i)%number/=0) then 
     print *, d(i)%number, d(i)%normed_value
    end if 
  end do


contains

  function sum_digits_squared (number) result (result)

    implicit none
    integer, intent (in) :: number
    integer :: result
    integer :: digit
    integer :: rest
    integer :: work

    result = 0
    work = number
    do
      if (work == 0) then
        exit
      end if
      rest = work / 10
      digit = work - 10 * rest
      result = result + digit * digit
      work = rest
    end do

  end function sum_digits_squared

  function is_happy (number_s) result (result)

    implicit none
    integer, intent (in) :: number_s
    logical :: result
    integer :: turtoise
    integer :: hare

    turtoise = number_s
    hare = number_s
    do
      turtoise = sum_digits_squared (turtoise)
      hare = sum_digits_squared (sum_digits_squared (hare))
      if (turtoise == hare) then
        exit
      end if
    end do
    result = turtoise == 1

  end function is_happy

  recursive function breakdown(number_r) result (sum1)
      implicit none
      integer :: a
      integer :: digit
      integer, intent (in) :: number_r
      integer :: sum1
      integer :: n
      sum1 = 0
      n = number_r

      a = 0
      do while(n> 0)
        digit = MOD(n, 10)
        n = n/10
        a = a + digit**2



      end do


      if(a /=1 ) then
          sum1 = + a**2 + breakdown(a)
          !print sum1

      !else
        !sum1 = sum1
      end if
  end function breakdown

  

end program happy
