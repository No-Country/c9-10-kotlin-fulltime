using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TEA.Models.DTOs.Posts;
using TEA.Models.Logs;

namespace TEA.Models.Entities
{
    public class Coment : Log
    {
        public int Id { get; set; }

        public string Message { get; set; }

        public int PostId { get; set; }

        public Post Post { get; set; }

        public int UserId { get; set; }

        public User User { get; set; }

        public int? Likes { get; set; }

        public int? Dislikes { get; set; }

        public static explicit operator Coment(ComentDTO entity)
        {
            return new Coment
            {
                Id = entity.Id,
                Message = entity.Message,
                PostId = entity.PostId,
                UserId = entity.UserId,
                Likes = entity.Likes,
                Dislikes = entity.Dislikes,

            };
        }
    }
}
