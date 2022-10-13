program happy

!JARRETT NOBLES
!CSC330
  implicit none
  !declare variables and data types
  type data_point
      integer :: number
      real :: normed_value
  end type data_point
  integer :: number,number2
  
  !allocate memory
  type(data_point):: d(10000),temp
  integer, parameter :: find = 30
  integer :: found,i,j
  integer :: count
  integer :: number3 
  real :: normedValue
  integer :: lsup,bubble
  lsup=10
  
  !get user input
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
  !calculating the norms   
  do while( number <=number2)
 
    if (is_happy (number)) then
      normedValue = sqrt(real((number**2+breakdown(number) + 1)))
      d(count)%normed_value=normedValue
      d(count)%number = number
      count = count + 1
    end if
    number = number + 1
  end do

  !this is where it is sorted via bubble sort
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

  !print the sorted values 
  do i = 1,10
    if(d(i)%number/=0) then 
     print *, d(i)%number
    end if 
  end do

contains
  !calculates happy number math 
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
  
  !figures out if a number is a happy number
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

  !breakdown the happy numbers and solve for the normed values
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
      end if

  end function breakdown

end program happy
