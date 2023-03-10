using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TEA.Models.Logs;

namespace TEA.Models.DTOs.Account
{
    public class UserRegisterDTO 
    {
        public string Name { get; set; }

        public string LastName { get; set; }

        public string UserName { get; set; }

        public string? ImageUrl { get; set; }

        public DateTime BirthDate { get; set; }

        public string? ProfileDescription { get; set; }

        public int? Gender { get; set; }

        public string Email { get; set; }

        public string Password { get; set; }
    }
}
